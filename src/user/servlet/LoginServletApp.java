package user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User;
import user.UserDAOFactory;

@WebServlet("/LoginServletApp")
public class LoginServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServletApp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
    	String userPhone = request.getParameter("userPhone");
    	String userPwd = request.getParameter("userPwd");
    	String userInfo = null;
    	try {
			User user = UserDAOFactory.getIUserDAOInstance().findByPhonePwd(userPhone, userPwd);
			if(user != null){
				int id = user.getUserId();
				String name = user.getUserName();
				String pwd = user.getUserPwd();
				String email = user.getUserEmail();
				String phone = user.getUserPhone();
				String sex = user.getUserSex();
				String city = user.getUserCity();
				int status = user.getUserStatus();
				Date regDate = user.getUserRegdata();
				userInfo = "{'id':'" + id + "','name':'" + name + "','pwd':'" + pwd + "','email':'" + email
						+ "','phone':'" + phone + "','sex':'" + sex + "','city':'" + city + "','status':'" + status
						+ "','rergDate':'" + regDate + "'}";
				System.out.println(userInfo);
			} else{
				userInfo = "{'id:'" + null + "','name':'" + null + "','pwd':'" + "','email':'"
						+ "','phone':'" +  "','sex':'" + "','city':'" + "','status':'"
						+ "','rergDate':'" + "'}";
			}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        if(userInfo != null && !userInfo.equals("")){
        	out.print(userInfo);
        }
        out.flush();
        out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
