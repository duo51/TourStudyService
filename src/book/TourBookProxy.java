package book;

import java.util.List;

import util.DBConn;

public class TourBookProxy implements ITourBookDao {
	
	private DBConn conn = null;
	private ITourBookDao dao = null;
	public TourBookProxy() throws Exception {
		this.conn = new DBConn();
		this.dao = new TourBookImpl(this.conn.getConnection());
	}

	@Override
	public boolean doCreateBook(TourBook book) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doCreateBook(book);
		} catch(Exception e){
			throw e;
		} finally{
//			this.conn.close();
		}
		return flag;	
	}

	@Override
	public List<TourBook> findAllBook() throws Exception {
		return null;
	}

}
