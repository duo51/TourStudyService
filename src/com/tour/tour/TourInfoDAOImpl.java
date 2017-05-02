package com.tour.tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TourInfoDAOImpl implements ITourInfoDao {
	
	private Connection conn = null;
	private PreparedStatement pStme = null;
	
	public TourInfoDAOImpl(Connection conn){
		this.conn = conn;
	}

	@Override
	public int findSum() throws Exception {
		int sum = 0;
		String sql = "select SUM(tour_id) from tour_info where tour_status > 0";
		this.pStme = this.conn.prepareStatement(sql);
		//this.pStme.setInt(1, sum);
//?		this.pStme.close();		
		return sum;
	}

	@Override
	public TourInfo findByName(String name) throws Exception {
		String sql = "select * from tour_info where tour_name like '%" + name + "%'";
		System.out.println(sql);
		this.pStme = this.conn.prepareStatement(sql);
		ResultSet rs = this.pStme.executeQuery();
		TourInfo info = null;
		while(rs.next()){
			info = new TourInfo();
			info.setId(rs.getInt(1));
			info.setName(rs.getString(2));
			info.setImage(rs.getString(3));
			info.setInfo(rs.getString(4));
			info.setCity(rs.getString(5));
			info.setStatus(rs.getInt(6));
		}
		return info;
	}
}
