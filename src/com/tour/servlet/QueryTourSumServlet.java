package com.tour.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tour.tour.TourInfoDAOFactory;

@WebServlet("/QueryTourSumServlet")
public class QueryTourSumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QueryTourSumServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int sum = TourInfoDAOFactory.getInstance().findSum();
			PrintWriter out = response.getWriter();  
            out.print(sum);  
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
