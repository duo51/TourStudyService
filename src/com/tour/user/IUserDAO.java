package com.tour.user;

import java.util.List;

/**
 *
 * @author KL
 *
 */
public interface IUserDAO {
	
	/**  
     * ���ݿ����Ӳ�����һ����doXXX�ķ�ʽ������  
     *@param user Ҫ���ӵ����ݶ���  
     *@return �Ƿ����ӳɹ��ı��  
     *@throws Exception ���쳣���������ô�����  
     */  
    public boolean doCreate(User user)throws Exception ;
    
     /**  
     * ��ѯȫ�������ݣ�һ����findXX�ķ�ʽ������  
     *@param keyWord ��ѯ�ؼ���  
     *@return ����ȫ���Ĳ�ѯ�����ÿһ��User�����ʾ���һ�м�¼  
     *@throws Exception ���쳣���������ô�����  
     */  
    public List<User>findAll()throws Exception;  
    
     /**  
     * �����û���Ų�ѯ�û���Ϣ
     *@param  id �û����
     *@return  �û���vo����  
     *@throws Exception ���쳣���������ô�����  
     */  
    public User findByName(String name)throws Exception;  
    
    public User findByPhone(String name)throws Exception;
    
    //�����û�����������е�¼�жϣ��������û��������ֻ���
    public User findByPhonePwd(String phone, String pwd)throws Exception;
    
    //�޸��û�����
    public Boolean update(User user) throws Exception;
    
    public Boolean updateStatus(User user) throws Exception;

}
