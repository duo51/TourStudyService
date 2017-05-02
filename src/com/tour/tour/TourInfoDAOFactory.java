package com.tour.tour;

public class TourInfoDAOFactory {
	
	public static ITourInfoDao getInstance() throws Exception{
		return new TourInfoDAOProxy();
	}
}
