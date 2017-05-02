package com.tour.book;


public class TourBookFactory {
	public static ITourBookDao getITourBookDAOInstance() throws Exception{
		return new TourBookProxy();
	}
}
