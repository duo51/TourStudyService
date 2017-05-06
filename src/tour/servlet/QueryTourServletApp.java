package tour.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicToolBarUI.DockingListener;

import tour.Tour;
import tour.TourDAOFactory;
import user.User;
import user.UserDAOFactory;

/**
 * APP端查询所有游学线路
 * @author KL
 *
 */
@WebServlet("/QueryTourServletApp")
public class QueryTourServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public QueryTourServletApp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		String jsondata = null;
		String data = null;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			if(TourDAOFactory.getITourDAOInstance().findAll() == null){
				msg = "no data";
			} else{
				int num = Integer.parseInt(request.getParameter("id"));
				List<Tour> list = new ArrayList<Tour>();
				list = TourDAOFactory.getITourDAOInstance().findAll();
				Tour tour = list.get(num);
				int id = tour.getTourId();
				String name = tour.getTourName();
				String image = tour.getImage();
				String picInfo = tour.getInfo();
				int price = tour.getTourMoney();
				String endSignDate = tour.getTourSignEnd();
				String day = tour.getTourDay();
				
				jsondata = "{'id':" + id + ",'name':'" + name + "','image':'" + image + "','picInfo':'" 
									+ picInfo + "','price':" + price + ",'endSignDate':'" + endSignDate
									+ "','day':'" + day + "'}";
//				System.out.println("jsondata:" + jsondata);
				//不回传List类型给APP，而是分解了之后给App
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

    	if(msg != null && !msg.equals("")){
    		data = "{'jsondata':'" + msg + "'}";
//    		System.out.println(data);
    	} else {
    		data = jsondata;
//    		System.out.println(data);
    	}
		response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        out.print(data);  
        out.flush();  
        out.close();  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
