package com.tour.tour;

public interface ITourInfoDao {

	public int findSum() throws Exception;
	
	public TourInfo findByName(String name) throws Exception;
}
