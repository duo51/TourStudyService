package com.tour.tour;

import java.util.List;

import com.tour.util.DBConn;

/**
 * 游学路线实现连接数类
 * @author KL
 *
 */
public class TourDAOProxy implements ITourDAO {
	
	private DBConn conn = null;
	private ITourDAO dao = null;
	public TourDAOProxy() throws Exception {
		this.conn = new DBConn();
		this.dao = new TourDAOImpl(this.conn.getConnection());
	}

	@Override
	public boolean doCreate(Tour tour) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doCreate(tour);
		} catch(Exception e){
			throw e;
		} finally{
//			this.conn.close();
		}
		return flag;	
	}

	/**
	 * 查询游学路线表中的信息
	 */
	@Override
	public List<Tour> findAll() throws Exception {
		List<Tour> list = null;
		try{
			list = this.dao.findAll();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
//			this.conn.close();
		}
		return list;
	}
	
	@Override
	public List<TourInfo> findAllApp() throws Exception {
		List<TourInfo> list = null;
		try{
			list = this.dao.findAllApp();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
//			this.conn.close();
		}
		return list;
	}

	@Override
	public Tour findByName(String name) throws Exception {
		return null;
	}

	@Override
	public Boolean update(Tour tour) throws Exception {
		Boolean flag = false;
		try{
			flag = this.dao.update(tour);
		} catch(Exception e){
			throw e;
		} finally{
//			this.conn.close();
		}
		return flag;
	}

	@Override
	public Boolean updateStatus(Tour tour) throws Exception {
		Boolean flag = false;
		try{
			flag = this.dao.updateStatus(tour);
		} catch(Exception e){
			throw e;
		}
		return flag;
	}

}
