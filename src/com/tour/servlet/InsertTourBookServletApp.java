package com.tour.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tour.book.TourBook;
import com.tour.book.TourBookFactory;

@WebServlet("/InsertTourBookServletApp")
public class InsertTourBookServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertTourBookServletApp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Date myDate = new Date();
		int userId = Integer.parseInt(request.getParameter("userId"));
		int tourId = Integer.parseInt(request.getParameter("tourId"));
		int status = Integer.parseInt(request.getParameter("status"));
		System.out.println("userId:" + userId + "tourId:" + tourId + "status:" + status);
		TourBook book = new TourBook();
		book.setBookDate(myDate);
		book.setUserId(userId);
		book.setTourId(tourId);
		book.setStatus(status);
		
		try {
			Boolean flag = TourBookFactory.getITourBookDAOInstance().doCreateBook(book);
	    	String data = "{'flag':'" + flag + "'}";
	    	System.out.println(data);
			response.setContentType("text/json");
	        PrintWriter out = response.getWriter();
	        out.print(data);  
	        out.flush();  
	        out.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
