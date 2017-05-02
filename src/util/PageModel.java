package util;

import java.io.Serializable;
import java.util.List;

/***
 * 用于封装分页信息，如结果集，页码和记录等
 * @author Administrator
 *
 */
public class PageModel {
	
	private int currPage;	//当前页
	private int totalRecords;	//总记录数
	private List<?> list;	//结果集，因为不知道是什么类型的
	private int pageSize;	//每页显示的记录数
	private Serializable object;
	/***
	 * 获取总页数
	 * @return
	 */
	public int getTotalPage() {
		return (totalRecords+pageSize-1)/pageSize;
	}
	
	/***
	 * 获取第一页
	 * @return
	 */
	public int getFirstPage() {
		return 1;
	}
	
	/***
	 * 获取上一页
	 * @return
	 */
	public int getPreviousPage() {
		if(currPage<=1){
			return 1;
		}else {
			return currPage-1;
		}
	}
	
	/***
	 * 获取下一页
	 * @return
	 */
	public int getNextPage() {
		if(currPage>=getTotalPage()){
			return getLastPage();
		}else {
			return currPage+1;
		}
	}
	
	/***
	 * 获取最后一页
	 * @return
	 */
	public int getLastPage() {
		//如果总页数等于0返回1
		if(getTotalPage()<=0){
			return 1;
		}else {
			return getTotalPage();
		}
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Serializable getObject() {
		return object;
	}

	public void setObject(Serializable object) {
		this.object = object;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	
	
}
