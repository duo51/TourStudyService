package com.tour.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tour.user.User;
import com.tour.user.UserDAOFactory;

@WebServlet("/UpdateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateUserInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String msg = "";
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		User user = new User();
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		String userSex = request.getParameter("userSex");
		String userPwd = request.getParameter("userPwd");
		String userPwd2 = request.getParameter("userPwd2");
		String checkCode = request.getParameter("checkCode");
		int userId = Integer.parseInt(request.getParameter("userId"));
		String userCity = request.getParameter("prov") + request.getParameter("city");
		
		if(checkCode.equals("")){
			msg = "请输入验证码";
		}else{
			HttpSession session = request.getSession(true);
			if(!checkCode.equalsIgnoreCase((String)session.getAttribute("randCheckCode"))){
				msg = "输入的验证码不正确，请重新输入";
			}else{
				if(!userPwd.equals(userPwd2)){
					msg = "两次输入的密码不一致";
				} else {
					user.setUserPhone(userPhone);
					user.setUserPwd(userPwd);
					user.setUserSex(userSex);
					user.setUserEmail(userEmail);
					user.setUserId(userId);
					user.setUserCity(userCity);
					try{
						if(UserDAOFactory.getIUserDAOInstance().update(user)){
						    out.print("修改成功");
						    response.setHeader("refresh", "3;URL=managehead.jsp");
						}else{
							msg = "修改失败";
						}
					}catch(Exception e){
						e.printStackTrace();  
					}		
				}
			}
		}
		
		if(!msg.equals("")){
			rd = request.getRequestDispatcher("/manage_user.jsp");
    		request.setAttribute("err", msg);
    		rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
