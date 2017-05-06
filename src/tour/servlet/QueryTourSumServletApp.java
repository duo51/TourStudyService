package tour.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tour.TourDAOFactory;


@WebServlet("/QueryTourSumServletApp")
public class QueryTourSumServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QueryTourSumServletApp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int sum = TourDAOFactory.getITourDAOInstance().findSum();
//			System.out.println("sum=" + sum);
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
