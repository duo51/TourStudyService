package util;
//package com.tour.util;
//import java.sql.*;
///**
// * 发送语句到数据库
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
////	 * 执行数据库语句
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
////	 * 数据库更改方法
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
//            if (rs!=null) {//如果返回的结果集对象不能为空,就关闭连接
//                rs.close();
//                rs = null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        try {
//            if (ps!=null) {
//                ps.close();//关闭预编译对象
//                ps = null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        try {
//            if (conn!=null) {
//                conn.close();//关闭结果集对象
//                conn = null;
//            }   
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("连接关闭成功");
//    }
//    
//}
