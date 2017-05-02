package com.tour.tour;

import java.util.List;

/**
 * 游学路线接口
 * @author KL
 *
 */
public interface ITourDAO {
	
	/**
	 * 创建游学信息
	 * @param tour
	 * @return
	 * @throws Exception
	 */
	public boolean doCreate(Tour Tour)throws Exception ;
    
    /**
    * 查询全部的数据，一般以findXX的方式命名;
    *@param keyWord 查询关键字
    *@return 返回全部的查询结果，每一个Tour对象表示表的一行记录
    *@throws Exception 有异常交给被调用处处理  
    */  
   public List<Tour>findAll()throws Exception;
   
   public List<TourInfo>findAllApp() throws Exception;
   
   /**
    * 根据tour的name查找信息
    * @param name
    * @return
    * @throws Exception
    */
   public Tour findByName(String name)throws Exception;  

   //修改用户数据
   public Boolean update(Tour user) throws Exception;
   
   /**
    * 假删除游学路线(更改tour的状态为0)
    * @param user
    * @return
    * @throws Exception
    */
   public Boolean updateStatus(Tour user) throws Exception;

}
