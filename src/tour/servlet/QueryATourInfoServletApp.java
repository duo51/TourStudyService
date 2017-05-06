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

import tour.TourDAOFactory;

@WebServlet("/QueryATourInfoServletApp")
public class QueryATourInfoServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QueryATourInfoServletApp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		String jsondata = null;
		String data = null;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
//		try {
//			if(TourInfoDAOFactory.getInstance().findByName(name) == null){
//				msg = "no data";
//			} else{
//				TourInfo info = TourInfoDAOFactory.getInstance().findByName(name);
//				int id = info.getId();
//				String tourName = info.getName();
//				String image = info.getImage();
//				String picInfo = info.getInfo();
//				jsondata = "{'id':" + id + ",'name':'" + tourName + "','image':'" + image + "','picInfo':'" 
//									+ picInfo + "'}";
//				//不回传List类型给APP，而是分解了之后给App
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

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
