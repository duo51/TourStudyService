package tour.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tour.Tour;
import tour.TourDAOFactory;

@WebServlet("/QueryTourInfoServlet")
public class QueryTourInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QueryTourInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String errMsg = "";
		RequestDispatcher rd = null;
		try{
			if(TourDAOFactory.getITourDAOInstance().findAll() == null){
				errMsg = "没有查询到数据";
			} else {
			List<Tour> list = new ArrayList<Tour>(); 
			list = TourDAOFactory.getITourDAOInstance().findAll();
			rd = request.getRequestDispatcher("/manage_tour.jsp");
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
