package user;

import java.util.List;

import util.DBConn;

/**
 * 进行数据库的连接，不实现具体的查询相关操作
 * @author KL
 *
 */
public class UserDAOProxy implements IUserDAO {
	
	private DBConn conn = null;
	private IUserDAO dao = null;
	public UserDAOProxy() throws Exception {
		this.conn = new DBConn();
		this.dao = new UserDAOImpl(this.conn.getConnection());
	}
	
	@Override
	public boolean doCreate(User user) throws Exception {
		boolean flag = false;
		try {
			if(this.dao.findByName(user.getUserName()) == null){
				flag = this.dao.doCreate(user);
			}
		} catch(Exception e){
			throw e;
		} finally{
			this.conn.close();
		}
		return flag;
	}
	
	@Override
	public List<User> findAll() throws Exception {
		List<User> list = null;
		try{
			list = this.dao.findAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.conn.close();
		}       
		return list;
	}
	
	@Override
	public User findByName(String name) throws Exception {
		return null;
	}

	@Override
	public User findByPhone(String name) throws Exception {
		User user = null;
		try{
			user = this.dao.findByPhone(name);
		} catch(Exception e){
			throw e;
		} finally{
			this.conn.close();
		}
		return user;
	}

	@Override
	public User findByPhonePwd(String phone, String pwd) throws Exception {
		User user = null;
		try{
			user = this.dao.findByPhonePwd(phone, pwd);
		} catch(Exception e){
			throw e;
		} finally{
			this.conn.close();
		}
		return user;
	}

	@Override
	public Boolean update(User user) throws Exception {
		Boolean flag = false;
		try{
			flag = this.dao.update(user);
		} catch(Exception e){
			throw e;
		} finally{
			this.conn.close();
		}
		return flag;
	}

	@Override
	public Boolean updateStatus(User user) throws Exception {
		Boolean flag = false;
		try{
			flag = this.dao.updateStatus(user);
		} catch(Exception e){
			throw e;
		} finally{
			this.conn.close();
		}
		return flag;
	}

}
