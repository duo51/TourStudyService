package util;
//package com.tour.util;
//import java.sql.*;
///**
// * ������䵽���ݿ�
// * @author KL
// *
// */
//
//public class DB {
//	private Connection conn=null; 
//	private ResultSet rs=null;
////	private Statement stmt=null;
//	private PreparedStatement ps=null;
//	   
//	public DB(){
//		DBConn conn;
//		try {
//			conn = new DBConn();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////		this.conn=conn.getConnection();
//	}
////	   
////	public Connection getConn(){
////		return this.conn;
////	}
//
////	/**
////	 * ִ�����ݿ����
////	 * @param sql
////	 * @return
////	 */
////	public ResultSet execSelect(String sql){
////		try{
////			stmt=conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
////			rs=stmt.executeQuery(sql);
////		}catch(SQLException se){
////			System.out.print(se.getMessage());
////		}
////		
////		return rs;
////	}
////	
////	/**
////	 * ���ݿ���ķ���
////	 * @param sql
////	 * @return
////	 */
////	public String execUpdate(String sql) {
////		Statement stmt=null;
////		String flag="";
////		try{
////			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
////			stmt.executeUpdate(sql);
////			flag="success";
////		}catch(SQLException se){
////			System.out.print(se.getMessage());
////			flag="error";
////		}
////	
////		return flag;
////	}
////
////	public String exec(String sql) {
////		Statement stmt=null;
////		String flag="";
////		try{
////			stmt=conn.createStatement();
////			stmt.execute(sql);			
////			flag="success";
////		}catch(SQLException se){
////			System.out.print(se.getMessage());
////			flag="error";
////		}
////	
////		return flag;
////	}
//
//    public void setConnClose() {
//        try{
//        	conn.close();
//		} catch (Exception e) {
//        	e.printStackTrace();
//		}
//	}
//  
//	public void freeCon(){
//    	try {
//            if (rs!=null) {//������صĽ����������Ϊ��,�͹ر�����
//                rs.close();
//                rs = null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        try {
//            if (ps!=null) {
//                ps.close();//�ر�Ԥ�������
//                ps = null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        try {
//            if (conn!=null) {
//                conn.close();//�رս��������
//                conn = null;
//            }   
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("���ӹرճɹ�");
//    }
//    
//}
