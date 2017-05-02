package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.AnswerDao;
import table.Answer;
import table.Question;
import util.DateUtil;
import util.PageModel;

/**
 * Servlet implementation class AnswerServlet
 */
@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Answer answer;
	private AnswerDao answerDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
		ApplicationContext webContext = new ClassPathXmlApplicationContext("beans.xml");
		answerDao=webContext.getBean(AnswerDao.class);
		answer=new Answer();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("正在运行");
		String action=request.getParameter("action");
//		String action="selectAll";
//		String action="insert";
		System.out.println(action);
		answer=new Answer();
		String question_id=request.getParameter("question_id");
		String answer_id=request.getParameter("answer_id");
		String user_id=request.getParameter("user_id");
//		question=questionDao.findQuestion(Integer.valueOf(question_id));
		
		//写一个测试数据能否传到指定客户端的方法
		
		if(action.equals("firstSelectAnswer")){
			System.out.println("正在查找"+question_id);
//			String currPage=request.getParameter("currPage");
//			String user_id=request.getParameter("user_id");
			firstSelectAnswer(request, response, Integer.parseInt(question_id),Integer.parseInt(user_id));

		}
		if(action.equals("selectAll")){
			System.out.println("正在查找"+question_id);
			String currPage=request.getParameter("currPage");
//			String user_id=request.getParameter("user_id");
			selectAllAnswer(request, response, Integer.parseInt(question_id),Integer.parseInt(currPage),Integer.parseInt(user_id));
//			selectAllAnswer(request, response, 1,5,1);
		}
		if(action.equals("insert")){
			String answer_info=request.getParameter("answer_info");
//			System.out.println("回答内容"+answer_info);
			String answer_date=DateUtil.getDate();
			answer.setAnswer_date(answer_date);//
			answer.setAnswer_info(answer_info);//
			answer.setAnswer_user_id(Integer.parseInt(user_id));
			answer.setSupport_count(0);
			answer.setQuestion_id(Integer.parseInt(question_id));//
			insertAnswer(request, response, answer_date);
		}
//		if(action.equals("updateAnswerSupport")){
//			updateAnswerSupport(request, response, answer_id);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
	public void insertAnswer(HttpServletRequest request, HttpServletResponse response,String answer_date) throws ServletException, IOException {
//		AnswerDao answerDao=new AnswerDao();
		answerDao.insertAnswer(answer);
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println("success");
		System.out.println("success");
		
//		firstSelectAnswer(request, response, question_id, user_id);
	}
	
	public void selectAllAnswer(HttpServletRequest request, HttpServletResponse response,int question_id,int currPage,int user_id) throws ServletException, IOException {
//		AnswerDao answerDao=new AnswerDao();
//		PageModel pageModel=answerDao.findPaging(currPage, 5, Integer.valueOf(question_id));
		PageModel pageModel=answerDao.findPaging(currPage, 5, Integer.valueOf(question_id),Integer.valueOf(user_id));
		JSONObject object=new JSONObject(pageModel);
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println(object.toString());
		System.out.println(object.toString());
	}
	
	public void firstSelectAnswer(HttpServletRequest request, HttpServletResponse response,int question_id,int user_id) throws ServletException, IOException {
//		AnswerDao answerDao=new AnswerDao();
//		PageModel pageModel=answerDao.findPaging(currPage, 5, Integer.valueOf(question_id));
		PageModel pageModel=answerDao.firstFindPaging(1, 5, Integer.valueOf(question_id),Integer.valueOf(user_id));
		JSONObject object=new JSONObject(pageModel);
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println(object.toString());
		System.out.println(object.toString());
	}
	
//	public void updateAnswerSupport(HttpServletRequest request, HttpServletResponse response,String answer_id) throws ServletException, IOException {
////		AnswerDao answerDao=new AnswerDao();
//		answerDao.updateAnswerSupportCount(Integer.valueOf(answer_id));
//		PrintWriter out=response.getWriter();
//		out.println("success");
//	}

}
