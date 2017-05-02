package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.QuestionDao;
import table.Question;
import util.DateUtil;
import util.PageModel;

/**
 * Servlet implementation class QuestionServlet
 * 对客户端发送过来的问题处理
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private QuestionDao questionDao;
    private Question question;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * 此servlet被初始化的时候执行的方法 从Spring容器中获取commodityDao对象
	 **/
	public void init() throws ServletException {
		ApplicationContext webContext = new ClassPathXmlApplicationContext("beans.xml");
		questionDao=(QuestionDao) webContext.getBean(QuestionDao.class);
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
		if(action.equals("insert")){
			String question_user_id=request.getParameter("question_user_id");
			String question_title=request.getParameter("question_title");
			String question_info=request.getParameter("question_info");
			String tour_id=request.getParameter("tour_id");
			String question_date=DateUtil.getDate();
			question=new Question();
			question.setQuestion_user_id(Integer.parseInt(question_user_id));
//			question.setQuestion_user_id(3);
			question.setVisit_count(0);
			question.setAnswer_count(0);
			question.setQuestion_title(question_title);
			question.setQuestion_info(question_info);
			question.setQuestion_date(question_date);
			question.setTour_id(Integer.parseInt(tour_id));
			insertQuestion(request, response);
		}
		if(action.equals("selectAll")){
			String currPage=request.getParameter("currPage");
			String tour_id=request.getParameter("tour_id");
			System.out.println(currPage+tour_id);
			selectAllQuestion(request, response,Integer.parseInt(currPage),Integer.parseInt(tour_id));
//			selectAllQuestion(request, response,1,1);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
	public void insertQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		questionDao=new QuestionDao();
		questionDao.insertQuestion(question);
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println("success");
	}
	
	public void updateQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		questionDao=new QuestionDao();
		questionDao.updateQuestion(question);
	}
	
	public void selectAllQuestion(HttpServletRequest request, HttpServletResponse response,int currPage,int tour_id) throws ServletException, IOException {
//		questionDao=new QuestionDao();
		PageModel pageModel=questionDao.findPaging(currPage, 5,tour_id);
		JSONObject object=new JSONObject(pageModel);
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println(object.toString());
		System.out.println(object.toString());
	}
	
}
