package com.tour.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class TourBookImpl implements ITourBookDao{
	
	private Connection conn = null;
	private PreparedStatement pStme = null;
	
	public TourBookImpl(Connection conn){
		this.conn = conn;
	}

	@Override
	public boolean doCreateBook(TourBook book) throws Exception {
		
		boolean flag = false;
		String sql = "insert into tour_book"
				+ "(book_date,user_id,tour_id,book_status) "
				+ "value(?,?,?,?)";
		this.pStme = this.conn.prepareStatement(sql);
		this.pStme.setDate(1, new java.sql.Date(book.getBookDate().getTime()));
		this.pStme.setInt(2, book.getUserId());
		this.pStme.setInt(3, book.getTourId());
		this.pStme.setInt(4, book.getStatus());

		if(this.pStme.executeUpdate() > 0){
			flag = true;
		}
		this.pStme.close();
		this.conn.close();
		return flag;
		
	}

	@Override
	public List<TourBook> findAllBook() throws Exception {
		return null;
	}

}
