package com.tour.user;

import java.util.List;

/**
 *
 * @author KL
 *
 */
public interface IUserDAO {
	
	/**  
     * 数据库增加操作，一般以doXXX的方式命名；  
     *@param user 要增加的数据对象；  
     *@return 是否增加成功的标记  
     *@throws Exception 有异常交给被调用处处理  
     */  
    public boolean doCreate(User user)throws Exception ;
    
     /**  
     * 查询全部的数据，一般以findXX的方式命名；  
     *@param keyWord 查询关键字  
     *@return 返回全部的查询结果，每一个User对象表示表的一行记录  
     *@throws Exception 有异常交给被调用处处理  
     */  
    public List<User>findAll()throws Exception;  
    
     /**  
     * 根据用户编号查询用户信息
     *@param  id 用户编号
     *@return  用户的vo对象  
     *@throws Exception 有异常交给被调用处处理  
     */  
    public User findByName(String name)throws Exception;  
    
    public User findByPhone(String name)throws Exception;
    
    //根据用户名和密码进行登录判断，可输入用户名或者手机号
    public User findByPhonePwd(String phone, String pwd)throws Exception;
    
    //修改用户数据
    public Boolean update(User user) throws Exception;
    
    public Boolean updateStatus(User user) throws Exception;

}
