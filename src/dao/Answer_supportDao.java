package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import table.Answer_support;

public class Answer_supportDao {
//	private String flag; 	//判断该用户是否点赞

	private SessionFactory sessionFactory;
	private AnswerDao answerDao;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();	//获取当前Session
	}
	
	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}
	
	
	//取消赞
	public void delete(Answer_support answer_support){
		getSession().delete(answer_support);
	}
	
	//点赞
	public void insert(Integer user_id,Integer answer_id){
		Answer_support answer_support=new Answer_support();
//		Integer userInteger=user_id;
//		Integer answerInteger=answer_id;
		int user=user_id.intValue();
		int answer=answer_id.intValue();
		answer_support.setAnswer_id(answer);
		answer_support.setUser_id(user);
		answer_support.setState(1);
		getSession().save(answer_support);
	}
	
	public String update(Integer user_id,Integer answer_id){
		String hql="from Answer_support where user_id=? and answer_id=?";
		List<Answer_support> list=getSession().createQuery(hql)
				.setParameter(0, user_id)
				.setParameter(1, answer_id)
				.list();
		if(list.size()>0){
			if(list.get(0).getState()==0){//未点赞
				list.get(0).setState(1);
				getSession().flush();
				answerDao.upAnswerSupportCount(answer_id);
				return "red";//客户端点击后变红
				
			}else{//已点赞
				list.get(0).setState(0);
				getSession().flush();
				answerDao.downAnswerSupportCount(answer_id);
				return "gray";//客户端点击变黑
				
			}
		}else{
			insert(user_id,answer_id);//第一次点赞该回答
			answerDao.upAnswerSupportCount(answer_id);
			return "red";//客户端点击变红
			
		}
		
	}
	
	//客户端传过来当前的用户id和问题id，客户端显示是否点赞
	
	//根据answer_id和user_id查找这条回答该用户是否点赞
	public int select(Integer user_id,Integer answer_id) {
		String hql="from Answer_support where user_id=? and answer_id=?";
		List<Answer_support> list=getSession().createQuery(hql)
				.setParameter(0, user_id)
				.setParameter(1, answer_id)
				.list();
		if(list.size()>0){
			//该用户已点赞这条回答
//			delete(list.get(0));
			if(list.get(0).getState()==1){
				return 1;//表示已点赞
			}else {
				return 0;//有记录但未点赞
			}
		}else{
			//未点赞这条回答
//			Answer_support answer_support=new Answer_support();
//			Integer userInteger=user_id;
//			Integer answerInteger=answer_id;
//			int user=userInteger.intValue();
//			int answer=answerInteger.intValue();
//			answer_support.setAnswer_id(answer);
//			answer_support.setUser_id(user);
//			insert(answer_support);
			return 0;//表示没有记录
		}
		
	}
}
