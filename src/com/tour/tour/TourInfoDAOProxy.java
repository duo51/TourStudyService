package com.tour.tour;

import com.tour.util.DBConn;

public class TourInfoDAOProxy implements ITourInfoDao {
	
	private DBConn conn = null;
	private ITourInfoDao dao = null;
	public TourInfoDAOProxy() throws Exception {
		this.conn = new DBConn();
		this.dao = new TourInfoDAOImpl(this.conn.getConnection());
	}

	@Override
	public int findSum() throws Exception {
		int sum = 0;
		try {
			sum = this.dao.findSum();
		} catch(Exception e){
			throw e;
		} finally{
			this.conn.close();
		}
		return sum;
	}

	@Override
	public TourInfo findByName(String name) throws Exception {
		TourInfo info = null;
		try{
			info = this.dao.findByName(name);
		} catch(Exception e){
			e.printStackTrace();
		} finally{
//			this.conn.close();
		}
		return info;
	}

}
