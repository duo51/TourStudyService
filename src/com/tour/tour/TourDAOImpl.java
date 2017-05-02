package com.tour.tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 游学路线实现具体的对数据库操作类
 * @author KL
 *
 */
public class TourDAOImpl implements ITourDAO {
	
	private Connection conn = null;
	private PreparedStatement pStme = null;
	
	public TourDAOImpl(Connection conn){
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Tour tour) throws Exception {
		boolean flag = false;
		String sql = "insert into tour_stu"
				+ "(tour_name,tour_style,tour_country,tour_city,tour_age,tour_money,"
				+ "tour_sign_start,tour_sign_end,tour_go,tour_need_person,tour_signed,tour_deposit,tour_info,tour_day) "
				+ "value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.pStme = this.conn.prepareStatement(sql);
		this.pStme.setString(1, tour.getTourName());
		this.pStme.setString(2, tour.getTourStyle());
		this.pStme.setString(3, tour.getTourCountry());
		this.pStme.setString(4, tour.getTourCity());
		this.pStme.setString(5, tour.getTourAge());
		this.pStme.setInt(6, tour.getTourMoney());
		this.pStme.setString(7, tour.getTourSignStart());
		this.pStme.setString(8, tour.getTourSignEnd());
		this.pStme.setString(9, tour.getTourGo());
		this.pStme.setInt(10, tour.getTourNeedPerson());
		this.pStme.setInt(11, tour.getTourSigned());
		this.pStme.setInt(12, tour.getTourDeposit());
		this.pStme.setString(13, tour.getTourInfo());
		this.pStme.setString(14, tour.getTourDay());

		if(this.pStme.executeUpdate() > 0){
			flag = true;
		}
		this.pStme.close();
		this.conn.close();
		return flag;
	}

	@Override
	public List<Tour> findAll() throws Exception {
		List<Tour> list = new ArrayList<Tour>();
		
		String sql = "select * from tour_stu where tour_status > 0";
		this.pStme = this.conn.prepareStatement(sql);
		ResultSet rs = this.pStme.executeQuery();
		Tour tour = null;
		while(rs.next()){
			tour = new Tour();
			tour.setTourId(rs.getInt(1));
			tour.setTourName(rs.getString(2));
			tour.setTourStyle(rs.getString(3));
			tour.setTourCountry(rs.getString(4));
			tour.setTourCity(rs.getString(5));
			tour.setTourAge(rs.getString(6));
			tour.setTourMoney(rs.getInt(7));
			tour.setTourSignStart(rs.getString(8));
			tour.setTourSignEnd(rs.getString(9));
			tour.setTourGo(rs.getString(10));
			tour.setTourNeedPerson(rs.getInt(11));
			tour.setTourSigned(rs.getInt(12));
			tour.setTourDeposit(rs.getInt(13));
			tour.setTourInfo(rs.getString(14));
			tour.setTourStatus(rs.getInt(15));
			tour.setTourDay(rs.getString(16));
			list.add(tour);
		}
		return list;
	}
	
	@Override
	public List<TourInfo> findAllApp() throws Exception {
		List<TourInfo> list = new ArrayList<TourInfo>();
		
		String sql = "select * from tour_info where tour_status > 0";
		this.pStme = this.conn.prepareStatement(sql);
		ResultSet rs = this.pStme.executeQuery();
		TourInfo tour = null;
		while(rs.next()){
			tour = new TourInfo();
			tour.setId(rs.getInt(1));
			tour.setName(rs.getString(2));
			tour.setImage(rs.getString(3));
			tour.setInfo(rs.getString(4));
			tour.setCity(rs.getString(5));
			tour.setStatus(rs.getInt(6));
			list.add(tour);
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
		String sql = "update tour_stu "
				+ "set tour_name=?,tour_style=?,tour_country=?,tour_city=?,tour_age=?,"
				+ "tour_money=?,tour_sign_start=?,tour_sign_end=?,tour_go=?,tour_need_person=?,"
				+ "tour_signed=?,tour_deposit=?,tour_info=?,tour_status=?,tour_day=?"
				+ "where tour_id=?";
//		Date date1 = StrToSqlDate.StringToSqlDate(tour.getTourSignStart());
//		Date date2 = StrToSqlDate.StringToSqlDate(tour.getTourSignEnd());
//		Date date3 = StrToSqlDate.StringToSqlDate(tour.getTourGo());
		this.pStme = this.conn.prepareStatement(sql);
		this.pStme.setString(1, tour.getTourName());
		this.pStme.setString(2, tour.getTourStyle());
		this.pStme.setString(3, tour.getTourCountry());
		this.pStme.setString(4, tour.getTourCity());
		this.pStme.setString(5, tour.getTourAge());
		this.pStme.setInt(6, tour.getTourMoney());
		this.pStme.setString(7, tour.getTourSignStart());
		this.pStme.setString(8, tour.getTourSignEnd());
		this.pStme.setString(9, tour.getTourGo());
		this.pStme.setInt(10, tour.getTourNeedPerson());
		this.pStme.setInt(11, tour.getTourSigned());
		this.pStme.setInt(12, tour.getTourDeposit());
		this.pStme.setString(13, tour.getTourInfo());
		this.pStme.setInt(14, tour.getTourStatus());
		this.pStme.setString(15, tour.getTourDay());
		this.pStme.setInt(16, tour.getTourId());

		int count = this.pStme.executeUpdate();
		if(count > 0){
			flag = true;;
		}
		return flag;
	}

	@Override
	public Boolean updateStatus(Tour tour) throws Exception {
		Boolean flag = false;
		String sql = "update tour_stu set tour_status = 0 where tour_id = ?";
		this.pStme = this.conn.prepareStatement(sql);
		this.pStme.setInt(1, tour.getTourId());
		int count = this.pStme.executeUpdate();
		if(count > 0){
			flag = true;
		}
		return flag;
	}

}
