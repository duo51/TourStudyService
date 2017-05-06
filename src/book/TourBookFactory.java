package book;


public class TourBookFactory {
	public static ITourBookDao getITourBookDAOInstance() throws Exception{
		return new TourBookProxy();
	}
}
