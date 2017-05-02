package com.tour.servlet;

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

import com.tour.tour.TourDAOFactory;
import com.tour.tour.TourInfo;
import com.tour.user.User;
import com.tour.user.UserDAOFactory;

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
			if(TourDAOFactory.getITourDAOInstance().findAllApp() == null){
				msg = "no data";
			} else{
				int num = Integer.parseInt(request.getParameter("id"));
				List<TourInfo> list = new ArrayList<TourInfo>();
				list = TourDAOFactory.getITourDAOInstance().findAllApp();
				TourInfo info = list.get(num);
				int id = info.getId();
				String name = info.getName();
				String image = info.getImage();
				String picInfo = info.getInfo();
				jsondata = "{'id':" + id + ",'name':'" + name + "','image':'" + image + "','picInfo':'" 
									+ picInfo + "'}";
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
