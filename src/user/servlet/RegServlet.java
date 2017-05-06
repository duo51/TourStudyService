package user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Generated;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;
import user.UserDAOFactory;

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String errMsg = "";
		RequestDispatcher rd = null;
		User user = new User();
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		String userSex = request.getParameter("userSex");
		String userPwd = request.getParameter("userPwd");
		String userPwd2 = request.getParameter("userPwd2");
		String checkCode = request.getParameter("checkCode");
		String userCity = request.getParameter("prov") + request.getParameter("city");

		if(checkCode.equals("")){
			errMsg = "��������֤��";
		}else{
			HttpSession session = request.getSession();
			if(!checkCode.equalsIgnoreCase((String)session.getAttribute("randCheckCode"))){
				errMsg = "��֤�벻��ȷ,����������";
			}else{
				if(!userPwd.equals(userPwd2)){
					errMsg = "��������� ���벻��ͬ,����������";
				} else{
					//������Ĭ��״̬��������Ϊ�����ʵ���ֻ�����֤����Email��֤֮���ڸĳ�0
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
							PrintWriter out = response.getWriter();
							out.print("ע��ɹ�");
							response.setHeader("refresh", "2;URL=login.jsp");
						}else{
							errMsg = "ע��ʧ��";
						}
					}catch(Exception e){
						e.printStackTrace();  
					}
				}
			}
		}
		
		if(errMsg != null){
			if(errMsg != null && !errMsg.equals("")){
	    		rd = request.getRequestDispatcher("/reg.jsp");
	    		request.setAttribute("err", errMsg);
	    		rd.forward(request, response);
	    	}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
