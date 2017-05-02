package com.tour.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tour.user.User;
import com.tour.user.UserDAOFactory;

@WebServlet("/RegServletApp")
public class RegServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegServletApp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		User user = new User();
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		String userSex = request.getParameter("userSex");
		String userPwd = request.getParameter("userPwd");
		String userPwd2 = request.getParameter("userPwd2");
		String userCity = request.getParameter("prov") + request.getParameter("city");

		if(!userPwd.equals(userPwd2)){
			message = "��������� ���벻��ͬ,����������";
		} else{
			//������Ĭ��״̬��������Ϊ�����ʵ���ֻ�����֤����Email��֤֮���ٸĳ�0
			int status = 1;
			//Integer.parseInt(request.getParameter("userType"));
			Date myDate = new Date();
//					String date = myDate.toString();
			
			user.setUserName(userName);
			user.setUserPhone(userPhone);
			user.setUserPwd(userPwd);
			user.setUserSex(userSex);
			user.setUserEmail(userEmail);
			user.setUserCity(userCity);
			user.setUserRegdata(myDate);
			user.setUserStatus(status);
			try{
				if(UserDAOFactory.getIUserDAOInstance().doCreate(user)){
					message = ("ע��ɹ�");
				}else{
					message = "ע��ʧ��";
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(message != null && !message.equals("")){
    		response.setContentType("text/json");
    		String data = "{'message':'" + message + "'}";
    		System.out.println(data);
            PrintWriter out = response.getWriter();
            out.print(data);  
            out.flush();
            out.close();
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
