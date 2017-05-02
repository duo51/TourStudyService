package util;

import java.io.Serializable;
import java.util.List;

/***
 * ���ڷ�װ��ҳ��Ϣ����������ҳ��ͼ�¼��
 * @author Administrator
 *
 */
public class PageModel {
	
	private int currPage;	//��ǰҳ
	private int totalRecords;	//�ܼ�¼��
	private List<?> list;	//���������Ϊ��֪����ʲô���͵�
	private int pageSize;	//ÿҳ��ʾ�ļ�¼��
	private Serializable object;
	/***
	 * ��ȡ��ҳ��
	 * @return
	 */
	public int getTotalPage() {
		return (totalRecords+pageSize-1)/pageSize;
	}
	
	/***
	 * ��ȡ��һҳ
	 * @return
	 */
	public int getFirstPage() {
		return 1;
	}
	
	/***
	 * ��ȡ��һҳ
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
	 * ��ȡ��һҳ
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
	 * ��ȡ���һҳ
	 * @return
	 */
	public int getLastPage() {
		//�����ҳ������0����1
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
