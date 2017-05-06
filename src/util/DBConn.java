package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ڼ���JDBC����
 * URL�������������ݿ�ı�ʶ��
 * USER �ǰ�װMySQLʱʹ�õ��û���
 * PASSWORD �����û������Ӧ������
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
            System.out.println("�ɹ�����MYSQL����");
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
				System.out.println("�����ѶϿ�");
			} catch(Exception e){
				throw e;
			}
		}
	}

}