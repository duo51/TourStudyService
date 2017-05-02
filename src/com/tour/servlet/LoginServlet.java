package com.tour.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tour.user.User;
import com.tour.user.UserDAOFactory;

/**
 * 登录判断页面的Servlet
 * @author KL
 *
 */
@WebServlet(name="LoginServlet",urlPatterns={"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//给JSP页面用于显示错误信息的字符串
    	String errMsg = "";
    	//转发对象
    	RequestDispatcher rd = null;
    	HttpSession session = request.getSession(true);
//    	int check = 0;
    	String userPhone = request.getParameter("userPhone");
    	String userPwd = request.getParameter("userPwd");
//    	String checkCode = request.getParameter("checkCode");
    	String requestFrom = request.getParameter("flag");
    	Boolean flag = true;
    	try {
    		
    		//在web端发送一个隐藏的标记，表明是web端发送过来的数据
    		//如果是web端，则需要进行验证码的检查
    		//如果不是web端，则是APP端，不需要进行验证码的检查
    		if(requestFrom.equals("web")){
    			String checkCode = request.getParameter("checkCode");
    			if(checkCode.equals("") && checkCode==""){
        			errMsg = "请输入验证码";
        			flag = false;
        		}else{
        			if(!checkCode.equalsIgnoreCase(session.getAttribute("randCheckCode").toString())){
        				errMsg = "验证码不正确,请重新输入";
        				flag = false;
        			}
        		}	
        	}
    		
    		if(flag){
    			User user = UserDAOFactory.getIUserDAOInstance().findByPhonePwd(userPhone, userPwd);
    			if(user != null){
    				session.setAttribute("userName", user.getUserName());
    				switch(user.getUserStatus()){
    					case 1:
    						//获取转发对象
//    						System.out.println("case1");
    						rd = request.getRequestDispatcher("/index.jsp");
    						//进行转发
    						rd.forward(request, response);
    						break;
    					case 2:
//    						System.out.println("case2");
    						rd = request.getRequestDispatcher("/managehead.jsp");
    						rd.forward(request, response);
    						break;
    					default:
    						System.out.println("DEFAULT");
    						errMsg = "状态为未激活,跳转回登录界面";
    						break;
    				}			
    			} else{
    				errMsg = "用户名或密码错误";
    			}
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if(errMsg != null && !errMsg.equals("")){
    		rd = request.getRequestDispatcher("/login.jsp");
    		request.setAttribute("err", errMsg);
    		rd.forward(request, response);
    	}
    }

}
