package tour.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tour.Tour;
import tour.TourDAOFactory;


@WebServlet("/UpdateToutInfoServlet")
public class UpdateToutInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateToutInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String msg = "";
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		try{
			Tour tour = new Tour();
			int tourId = Integer.parseInt(request.getParameter("tourId"));
			String tourName = request.getParameter("tourName");
			String tourStyle = request.getParameter("tourStyle");
			String tourCountry = request.getParameter("tourCountry");
			String tourCity = request.getParameter("tourCity");
			String tourAge = request.getParameter("tourAge");
			int tourMoney = Integer.parseInt(request.getParameter("tourMoney"));
			String signStart = request.getParameter("tourSignStrat");
			String signEnd = request.getParameter("tourSignEnd");
			String tourGo = request.getParameter("tourGo");
			int tourNeedPerson = Integer.parseInt(request.getParameter("tourNeedPerson"));
//			System.out.println(request.getParameter("tourSigned"));
			int tourSigned = Integer.parseInt(request.getParameter("tourSigned"));
			int tourDeposit = Integer.parseInt(request.getParameter("tourDeposit"));
			int tourStatus = Integer.parseInt(request.getParameter("tourStatus"));
			String day = request.getParameter("tourDay");
			String checkCode = request.getParameter("checkCode");

			if(checkCode.equals("")){
				msg = "请输入验证码";
			}else{
				HttpSession session = request.getSession(true);
				if(!checkCode.equalsIgnoreCase((String)session.getAttribute("randCheckCode"))){
					msg = "输入的验证码不正确，请重新输入";
				}else{
					tour.setTourId(tourId);
					tour.setTourName(tourName);
					tour.setTourStyle(tourStyle);
					tour.setTourCountry(tourCountry);
					tour.setTourCity(tourCity);
					tour.setTourAge(tourAge);
					tour.setTourMoney(tourMoney);
					tour.setTourSignStart(signStart);
					tour.setTourSignEnd(signEnd);
					tour.setTourGo(tourGo);
					tour.setTourNeedPerson(tourNeedPerson);
					tour.setTourSigned(tourSigned);
					tour.setTourDeposit(tourDeposit);
					tour.setTourStatus(tourStatus);
					tour.setTourDay(day);
						if(TourDAOFactory.getITourDAOInstance().update(tour)){
						    out.print("修改成功");
						    response.setHeader("refresh", "3;URL=managehead.jsp");
						}else{
							msg = "修改失败";
							out.print("修改失败");
						}
				}
			}
		}catch(Exception e){
			e.printStackTrace();  
			out.println("catch");
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
