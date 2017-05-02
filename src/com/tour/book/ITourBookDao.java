package com.tour.book;

import java.util.List;

public interface ITourBookDao {

	public boolean doCreateBook(TourBook book) throws Exception;
	
	public List<TourBook> findAllBook() throws Exception;
	
}
