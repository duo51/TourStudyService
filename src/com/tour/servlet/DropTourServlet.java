package com.tour.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tour.tour.Tour;
import com.tour.tour.TourDAOFactory;

@WebServlet("/DropTourServlet")
public class DropTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DropTourServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tour tour = new Tour();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		tour.setTourId(Integer.parseInt(request.getParameter("tourId")));
		try{
			if(TourDAOFactory.getITourDAOInstance().updateStatus(tour)){
				PrintWriter out = response.getWriter();
				out.print("É¾³ý³É¹¦");
				response.setHeader("refresh", "2;URL=managehead.jsp");
			} else{
				PrintWriter out = response.getWriter();
				out.print("É¾³ýÊ§°Ü");
				response.setHeader("refresh", "2;URL=managehead.jsp");
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
