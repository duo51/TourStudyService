package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 用于加载JDBC驱动
 * URL是用于连接数据库的标识符
 * USER 是安装MySQL时使用的用户名
 * PASSWORD 是与用户名相对应的密码
 */

public class DBConn {
	
	private static final String Driver="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/study_tour?serverTimezone=UTC&useSSL=false";
	private static final String USER="root";
	private static final String PWD="215lliilan";
	
	private Connection conn = null;
	
	public DBConn() throws Exception{
		try {
			Class.forName(Driver);
            this.conn = DriverManager.getConnection(URL,USER,PWD);
            System.out.println("成功加载MYSQL驱动");
		} catch(Exception e){
			throw e;
		}
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	
	public void close() throws Exception{
		if(this.conn != null){
			try{
				this.conn.close();
				System.out.println("连接已断开");
			} catch(Exception e){
				throw e;
			}
		}
	}

}