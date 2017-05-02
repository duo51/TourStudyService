package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import table.Answer_support;

public class Answer_supportDao {
//	private String flag; 	//�жϸ��û��Ƿ����

	private SessionFactory sessionFactory;
	private AnswerDao answerDao;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();	//��ȡ��ǰSession
	}
	
	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}
	
	
	//ȡ����
	public void delete(Answer_support answer_support){
		getSession().delete(answer_support);
	}
	
	//����
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
			if(list.get(0).getState()==0){//δ����
				list.get(0).setState(1);
				getSession().flush();
				answerDao.upAnswerSupportCount(answer_id);
				return "red";//�ͻ��˵������
				
			}else{//�ѵ���
				list.get(0).setState(0);
				getSession().flush();
				answerDao.downAnswerSupportCount(answer_id);
				return "gray";//�ͻ��˵�����
				
			}
		}else{
			insert(user_id,answer_id);//��һ�ε��޸ûش�
			answerDao.upAnswerSupportCount(answer_id);
			return "red";//�ͻ��˵�����
			
		}
		
	}
	
	//�ͻ��˴�������ǰ���û�id������id���ͻ�����ʾ�Ƿ����
	
	//����answer_id��user_id���������ش���û��Ƿ����
	public int select(Integer user_id,Integer answer_id) {
		String hql="from Answer_support where user_id=? and answer_id=?";
		List<Answer_support> list=getSession().createQuery(hql)
				.setParameter(0, user_id)
				.setParameter(1, answer_id)
				.list();
		if(list.size()>0){
			//���û��ѵ��������ش�
//			delete(list.get(0));
			if(list.get(0).getState()==1){
				return 1;//��ʾ�ѵ���
			}else {
				return 0;//�м�¼��δ����
			}
		}else{
			//δ���������ش�
//			Answer_support answer_support=new Answer_support();
//			Integer userInteger=user_id;
//			Integer answerInteger=answer_id;
//			int user=userInteger.intValue();
//			int answer=answerInteger.intValue();
//			answer_support.setAnswer_id(answer);
//			answer_support.setUser_id(user);
//			insert(answer_support);
			return 0;//��ʾû�м�¼
		}
		
	}
}
