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
 * ��¼�ж�ҳ���Servlet
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
    	//��JSPҳ��������ʾ������Ϣ���ַ���
    	String errMsg = "";
    	//ת������
    	RequestDispatcher rd = null;
    	HttpSession session = request.getSession(true);
//    	int check = 0;
    	String userPhone = request.getParameter("userPhone");
    	String userPwd = request.getParameter("userPwd");
//    	String checkCode = request.getParameter("checkCode");
    	String requestFrom = request.getParameter("flag");
    	Boolean flag = true;
    	try {
    		
    		//��web�˷���һ�����صı�ǣ�������web�˷��͹���������
    		//�����web�ˣ�����Ҫ������֤��ļ��
    		//�������web�ˣ�����APP�ˣ�����Ҫ������֤��ļ��
    		if(requestFrom.equals("web")){
    			String checkCode = request.getParameter("checkCode");
    			if(checkCode.equals("") && checkCode==""){
        			errMsg = "��������֤��";
        			flag = false;
        		}else{
        			if(!checkCode.equalsIgnoreCase(session.getAttribute("randCheckCode").toString())){
        				errMsg = "��֤�벻��ȷ,����������";
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
    						//��ȡת������
//    						System.out.println("case1");
    						rd = request.getRequestDispatcher("/index.jsp");
    						//����ת��
    						rd.forward(request, response);
    						break;
    					case 2:
//    						System.out.println("case2");
    						rd = request.getRequestDispatcher("/managehead.jsp");
    						rd.forward(request, response);
    						break;
    					default:
    						System.out.println("DEFAULT");
    						errMsg = "״̬Ϊδ����,��ת�ص�¼����";
    						break;
    				}			
    			} else{
    				errMsg = "�û������������";
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
