package com.tour.tour;

public class TourDAOFactory {
	
	public static ITourDAO getITourDAOInstance() throws Exception{
		return new TourDAOProxy();
	}
	
}
