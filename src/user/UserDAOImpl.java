package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现具体的数据库相关操作
 * @author KL
 *
 */
public class UserDAOImpl implements IUserDAO {
	
	private Connection conn = null;
	private PreparedStatement pStme = null;
	
	public UserDAOImpl(Connection conn){
		this.conn = conn;
	}

	@Override
	public boolean doCreate(User user) throws Exception {
		boolean flag = false;
		String sql = "insert into user_info(user_name,user_pwd,user_email,user_phone,user_sex,user_city,user_status,user_regdate) "
				+ "value(?,?,?,?,?,?,?,?)";
		this.pStme = this.conn.prepareStatement(sql);
		this.pStme.setString(1, user.getUserName());
		this.pStme.setString(2, user.getUserPwd());
		this.pStme.setString(3, user.getUserEmail());
		this.pStme.setString(4, user.getUserPhone());
		this.pStme.setString(5, user.getUserSex());
		this.pStme.setString(6, user.getUserCity());
		this.pStme.setInt(7, user.getUserStatus());
		this.pStme.setDate(8, new java.sql.Date(user.getUserRegdata().getTime()));
		if(this.pStme.executeUpdate() > 0){
			flag = true;
		}
		this.pStme.close();
		return flag;
	}

	@Override
	public List<User> findAll() throws Exception {
		List<User> userinfo = new ArrayList<User>();
		String sql = "select user_id,user_name,user_email,user_phone,user_sex,user_city,user_status,user_regdate "
				+ "from user_info where user_status > 0";
//		System.out.println(sql);
		this.pStme = this.conn.prepareStatement(sql);
		ResultSet rs = this.pStme.executeQuery();
		User user = null;
		while(rs.next()){
			user = new User();
			user.setUserId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setUserEmail(rs.getString(3));
			user.setUserPhone(rs.getString(4));
			user.setUserSex(rs.getString(5));
			user.setUserCity(rs.getString(6) + "");
			user.setUserStatus(rs.getInt(7));
			user.setUserRegdata(rs.getDate(8));
			userinfo.add(user);
		}
		this.pStme.close();
		return userinfo;
	}

	@Override
	public User findByName(String name) throws Exception {
		return null;
	}

	@Override
	public User findByPhone(String name) throws Exception {
		User user = null;
		String sql = "select * from user_info where user_phone=?";
		this.pStme = this.conn.prepareStatement(sql);
		this.pStme.setString(1, name);
		ResultSet rs = this.pStme.executeQuery();
		if(rs.next()){
			user = new User();
			user.setUserName(rs.getString(1));
			user.setUserEmail(rs.getString(3));
			user.setUserPhone(rs.getString(4));
			user.setUserSex(rs.getString(5));
			user.setUserCity(rs.getString(6));
			user.setUserStatus(rs.getInt(7));
			user.setUserRegdata(rs.getDate(8));
		}
		this.pStme.close();
		rs.close();
		return user;
	}

	@Override
	public User findByPhonePwd(String phone, String pwd) throws Exception {
		User user = null;
		String sql = "select * from user_info where (user_phone=? and user_pwd=?) or (user_name=? and user_pwd=?)";
		this.pStme = this.conn.prepareStatement(sql);
		this.pStme.setString(1, phone);
		this.pStme.setString(2, pwd);
		this.pStme.setString(3, phone);
		this.pStme.setString(4, pwd);
		ResultSet rs = this.pStme.executeQuery();
		if(rs.next()){
			user = new User();
			user.setUserName(rs.getString(2));
			user.setUserStatus(rs.getInt(8));	//用户状态及权限
			user.setUserId(rs.getInt(1));
		}
		this.pStme.close();
		return user;
	}

	@Override
	public Boolean update(User user) throws Exception {
		Boolean flag = false;
		String sql = "update user_info set user_pwd=?,user_email=?,user_phone=?,user_sex=?,user_city=? where user_id=?";
		this.pStme = this.conn.prepareStatement(sql);
		this.pStme.setString(1, user.getUserPwd());
		this.pStme.setString(2, user.getUserEmail());
		this.pStme.setString(3, user.getUserPhone());
		this.pStme.setString(4, user.getUserSex());
		this.pStme.setString(5, user.getUserCity());
		this.pStme.setInt(6, user.getUserId());
		int count = this.pStme.executeUpdate();
		if(count > 0){
			flag = true;;
		}
		return flag;
	}

	@Override
	public Boolean updateStatus(User user) throws Exception {
		Boolean flag = false;
		String sql = "update user_info set user_status = 0 where user_id = ?";
		this.pStme = this.conn.prepareStatement(sql);
		this.pStme.setInt(1, user.getUserId());
		int count = this.pStme.executeUpdate();
		if(count > 0){
			flag = true;
		}
		return flag;
	}
	
}
