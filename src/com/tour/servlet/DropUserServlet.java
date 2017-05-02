package com.tour.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tour.user.User;
import com.tour.user.UserDAOFactory;

@WebServlet("/DropUserServlet")
public class DropUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DropUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setUserId(Integer.parseInt(request.getParameter("userId")));
		try{
			if(UserDAOFactory.getIUserDAOInstance().updateStatus(user)){
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
