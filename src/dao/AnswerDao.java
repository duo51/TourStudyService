package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import table.Answer;
import table.Question;
import util.DateUtil;
import util.PageModel;

public class AnswerDao {
	
	private SessionFactory sessionFactory;
	private QuestionDao questionDao;
	private Answer_supportDao answer_supportDao;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	
	public void setAnswer_supportDao(Answer_supportDao answer_supportDao) {
		this.answer_supportDao = answer_supportDao;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();	//获取当前Session
	}
	/***
	 * 增加问题记录
	 * @param question
	 */
	public void insertAnswer(Answer answer){
//		Session session=sessionFactory.openSession();
//		System.out.println(session);
//		session.beginTransaction();
//		session.save(answer);
		getSession().save(answer);
		//有人回答了修改问题的回答数
		int question_id=answer.getQuestion_id();
//		session.getTransaction().commit();
//		session.close();
//		QuestionDao questionDao=new QuestionDao();
		questionDao.updateQuestionAnswerCount(Integer.valueOf(question_id));
//		findPaging(1, pageSize, Integer.valueOf(question_id), user_id);
	}
	
	/***
	 * 获取全部的问题记录
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Answer> selectQuestion(Integer question_id){
//		Session session=sessionFactory.openSession();
		List<Answer> answerlist=null;
//		session.beginTransaction();
		String hql="from Answer where question_id=? order by answer_date desc";
		answerlist=getSession().createQuery(hql)	
				.setParameter(0, question_id)
				.list();
//		session.getTransaction().commit();
//		session.close();
		return answerlist;
	}
	
	/***
	 * 分页查询问题记录
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PageModel findPaging(int currPage,int pageSize,Integer question_id,Integer user_id) {
//		Session session=sessionFactory.openSession();
		PageModel pageModel=new PageModel();
//		session.beginTransaction();
		String hql="from Answer where question_id=? order by answer_id desc";
		List<Answer> answerList=getSession().createQuery(hql)
				.setParameter(0, question_id)
				.setFirstResult((currPage-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
//		List<Answer> answerList=new ArrayList<Answer>();
//		List<Question> questionList=session.createQuery("from Question where question_id=?")
//				.setParameter(0, question_id)
//				.list();
//		List<Question> questionList=new ArrayList<Question>();
//		Question q=(Question) getSession().get(Question.class, question_id);
//		questionList.add(q);
//		Set<Answer> a=q.getAnswers();
//		for(Iterator<Answer> it=a.iterator();it.hasNext();){
//			Answer answer=it.next();
		for(int i=0;i<answerList.size();i++){
			Answer answer=answerList.get(i);
			int answer_id=answer.getAnswer_id();
			int s=answer_supportDao.select(user_id, Integer.valueOf(answer_id));
			System.out.println(s);
			answer.setShowState(s);
		}
		pageModel.setList(answerList);
		pageModel.setPageSize(pageSize);
		pageModel.setCurrPage(currPage);
		pageModel.setTotalRecords(getTotalRecords(getSession()));
//		session.getTransaction().commit();
//		session.close();
//		QuestionDao questionDao=new QuestionDao();
//		questionDao.updateQuestionVisitCount(question_id);
		return pageModel;
	}
	
	@SuppressWarnings("unchecked")
	public PageModel firstFindPaging(int currPage,int pageSize,Integer question_id,Integer user_id) {
//		Session session=sessionFactory.openSession();
		PageModel pageModel=new PageModel();
//		session.beginTransaction();
		String hql="from Answer where question_id=? order by answer_id desc";
		List<Answer> answerList=getSession().createQuery(hql)
				.setParameter(0, question_id)
				.setFirstResult((currPage-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
//		List<Answer> answerList=new ArrayList<Answer>();
//		List<Question> questionList=session.createQuery("from Question where question_id=?")
//				.setParameter(0, question_id)
//				.list();
//		List<Question> questionList=new ArrayList<Question>();
//		Question q=(Question) getSession().get(Question.class, question_id);
//		questionList.add(q);
//		Set<Answer> a=q.getAnswers();
//		for(Iterator<Answer> it=a.iterator();it.hasNext();){
//			Answer answer=it.next();
		for(int i=0;i<answerList.size();i++){
			Answer answer=answerList.get(i);
			int answer_id=answer.getAnswer_id();
			int s=answer_supportDao.select(user_id, Integer.valueOf(answer_id));
			System.out.println(s);
			answer.setShowState(s);
		}
		pageModel.setList(answerList);
		pageModel.setPageSize(pageSize);
		pageModel.setCurrPage(currPage);
		pageModel.setTotalRecords(getTotalRecords(getSession()));
//		session.getTransaction().commit();
//		session.close();
//		QuestionDao questionDao=new QuestionDao();
		questionDao.updateQuestionVisitCount(question_id);
		return pageModel;
	}
	
	/***
	 * 更改问题记录
	 * @param answer
	 */
	public void updateQuestion(Answer answer) {
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
		getSession().saveOrUpdate(answer);
//		session.getTransaction().commit();
//		session.close();
	}
	
	/**
	 * 自动修改回答的点赞数
	 * @param answer_id
	 */
	public void upAnswerSupportCount(Integer answer_id){
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
		Answer answer=(Answer) getSession().load(Answer.class, answer_id);
		int supportCount=answer.getSupport_count();
		supportCount++;
		answer.setSupport_count(supportCount);
		getSession().flush();
//		session.getTransaction().commit();
//		session.close();
	}
	
	public void downAnswerSupportCount(Integer answer_id){
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
		Answer answer=(Answer) getSession().load(Answer.class, answer_id);
		int supportCount=answer.getSupport_count();
		supportCount--;
		answer.setSupport_count(supportCount);
		getSession().flush();
//		session.getTransaction().commit();
//		session.close();
	}
	
	/***
	 * 得到总记录数
	 * @param session
	 * @return
	 */
	public int getTotalRecords(Session session) {
		String hql="select count(*) from Answer";
		Long totalRecords=(Long) session.createQuery(hql).uniqueResult();
		return totalRecords.intValue();
	}
}
