package user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User;
import user.UserDAOFactory;

@WebServlet("/QueryUserInfoServlet")
public class QueryUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QueryUserInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String errMsg = "";
		
		try{
			if(UserDAOFactory.getIUserDAOInstance().findAll() == null){
				errMsg = "没有查询到数据";
			} else {
				List<User> list = new ArrayList<User>(); 
				list = UserDAOFactory.getIUserDAOInstance().findAll();
				rd = request.getRequestDispatcher("/manage_user.jsp");
				request.setAttribute("list", list);
	    		rd.forward(request, response);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		
		if(errMsg != null && !errMsg.equals("")){
    		rd = request.getRequestDispatcher("/managehead.jsp");
    		request.setAttribute("err", errMsg);
    		rd.forward(request, response);
    	}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
