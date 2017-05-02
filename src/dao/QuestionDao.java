package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import table.Question;
import util.DateUtil;
import util.PageModel;

public class QuestionDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();	//获取当前Session
	}
	
	/***
	 * 增加问题记录
	 * @param question
	 */
	public void insertQuestion(Question question){
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
		getSession().save(question);
//		session.getTransaction().commit();
//		session.close();
	}
	
	public Question findQuestion(Integer question_id){
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
		Question question=(Question) getSession().get(Question.class, question_id);
//		session.getTransaction().commit();
//		session.close();
		return question;
	}
	
	/***
	 * 获取全部的问题记录
	 * @return
	 */
	public List<Question> selectQuestion(){
//		Session session=sessionFactory.openSession();
		List<Question> questionlist=null;
//		session.beginTransaction();
		String hql="from Question";
		questionlist=getSession().createQuery(hql)				
				.list();
//		session.getTransaction().commit();
//		session.close();
		return questionlist;
	}
	
	/***
	 * 根据问题类型筛选问题记录
	 * @param question_type
	 * @return
	 */
	public List<Question> selectQuestion(String question_type){
//		Session session=sessionFactory.openSession();
		List<Question> questionlist=null;
//		session.beginTransaction();
		String hql="from Question where question_type=? order by question_date desc";
		questionlist=getSession().createQuery(hql)
				.setParameter(0, question_type)
				.list();
//		session.getTransaction().commit();
//		session.close();
		return questionlist;
	}
	
	/***
	 * 分页查询问题记录
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public PageModel findPaging(int currPage,int pageSize,int tour_id) {
//		Session session=sessionFactory.openSession();
		
		PageModel pageModel=new PageModel();
//		getSession().beginTransaction();
		String hql="from Question where tour_id=? order by question_id desc";
		Integer id=Integer.valueOf(tour_id);
		List<Question> list=getSession().createQuery(hql)
				.setParameter(0, id)
				.setFirstResult((currPage-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
		pageModel.setList(list);
		pageModel.setPageSize(pageSize);
		pageModel.setCurrPage(currPage);
		pageModel.setTotalRecords(getTotalRecords(getSession()));
//		getSession().getTransaction().commit();
//		getSession().close();
		return pageModel;
	}
	
	/***
	 * 更改问题记录
	 * @param question
	 */
	public void updateQuestion(Question question) {
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
		getSession().saveOrUpdate(question);
//		session.getTransaction().commit();
//		session.close();
	}
	
	/**
	 * 自动修改问题的回答数
	 * @param question_id
	 */
	public void updateQuestionAnswerCount(Integer question_id){
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
		Question question=(Question) getSession().load(Question.class, question_id);
		int answerCount=question.getAnswer_count();
		System.out.println("pls"+answerCount);
		answerCount++;
		question.setAnswer_count(answerCount);
		getSession().update(question);
		getSession().flush();
		System.out.println("plssss"+question.getAnswer_count());
		System.out.println("plssss"+question.getQuestion_id());
//		session.getTransaction().commit();
//		session.close();
	}
	
	/**
	 * 自动修改问题的浏览数
	 * @param question_id
	 */
	public void updateQuestionVisitCount(Integer question_id){
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
		
		Question question=(Question) getSession().load(Question.class, question_id);
		int visitCount=question.getVisit_count();
		System.out.println("pls"+visitCount);
		visitCount++;
		question.setVisit_count(visitCount);
		getSession().update(question);
		getSession().flush();
		System.out.println("plssssassa"+question.getVisit_count());
//		session.getTransaction().commit();
//		session.close();
	}
	
	
	
	/***
	 * 得到总记录数
	 * @param session
	 * @return
	 */
	public int getTotalRecords(Session session) {
		String hql="select count(*) from Question";
		Long totalRecords=(Long) session.createQuery(hql).uniqueResult();
		return totalRecords.intValue();
	}
}
