package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.AnswerDao;
import dao.Answer_supportDao;
import table.Answer;
import table.Answer_support;

/**
 * Servlet implementation class Answer_supportServlet
 */
@WebServlet("/Answer_supportServlet")
public class Answer_supportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Answer_supportDao answer_supportDao;
    private Answer_support answer_support;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Answer_supportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
		ApplicationContext webContext = new ClassPathXmlApplicationContext("beans.xml");
		answer_supportDao=webContext.getBean(Answer_supportDao.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id=request.getParameter("user_id");
		String answer_id=request.getParameter("answer_id");
		System.out.println(user_id+"u");
		System.out.println(answer_id+"a");
//		update(request, response, Integer.parseInt(user_id), Integer.parseInt(answer_id));
		update(request, response, Integer.parseInt(user_id), Integer.parseInt(answer_id));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response,int user_id,int answer_id) throws ServletException, IOException {
		String reply=answer_supportDao.update(Integer.valueOf(user_id), Integer.valueOf(answer_id));
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println(reply);
	}

}
