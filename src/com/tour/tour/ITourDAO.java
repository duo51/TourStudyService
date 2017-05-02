package com.tour.tour;

import java.util.List;

/**
 * ��ѧ·�߽ӿ�
 * @author KL
 *
 */
public interface ITourDAO {
	
	/**
	 * ������ѧ��Ϣ
	 * @param tour
	 * @return
	 * @throws Exception
	 */
	public boolean doCreate(Tour Tour)throws Exception ;
    
    /**
    * ��ѯȫ�������ݣ�һ����findXX�ķ�ʽ����;
    *@param keyWord ��ѯ�ؼ���
    *@return ����ȫ���Ĳ�ѯ�����ÿһ��Tour�����ʾ���һ�м�¼
    *@throws Exception ���쳣���������ô�����  
    */  
   public List<Tour>findAll()throws Exception;
   
   public List<TourInfo>findAllApp() throws Exception;
   
   /**
    * ����tour��name������Ϣ
    * @param name
    * @return
    * @throws Exception
    */
   public Tour findByName(String name)throws Exception;  

   //�޸��û�����
   public Boolean update(Tour user) throws Exception;
   
   /**
    * ��ɾ����ѧ·��(����tour��״̬Ϊ0)
    * @param user
    * @return
    * @throws Exception
    */
   public Boolean updateStatus(Tour user) throws Exception;

}
