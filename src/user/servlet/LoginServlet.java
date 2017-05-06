package user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;
import user.UserDAOFactory;

/**
 * ��¼�ж�ҳ���Servlet
 * @author KL
 *
 */
@WebServlet(name="LoginServlet",urlPatterns={"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//��JSPҳ��������ʾ������Ϣ���ַ���
    	String errMsg = "";
    	//ת������
    	RequestDispatcher rd = null;
    	HttpSession session = request.getSession(true);
    	String userPhone = request.getParameter("userPhone");
    	String userPwd = request.getParameter("userPwd");
    	Boolean flag = true;
    	try {
			String checkCode = request.getParameter("checkCode");
			if(checkCode.equals("") && checkCode==""){
    			errMsg = "��������֤��";
    			flag = false;
    		}else{
    			if(!checkCode.equalsIgnoreCase(session.getAttribute("randCheckCode").toString())){
    				errMsg = "��֤�벻��ȷ,����������";
    				flag = false;
    			}
    		}

    		if(flag){
    			User user = UserDAOFactory.getIUserDAOInstance().findByPhonePwd(userPhone, userPwd);
    			if(user != null){
    				session.setAttribute("userName", user.getUserName());
    				switch(user.getUserStatus()){
    					case 1:
    						//��ȡת������
//    						rd = request.getRequestDispatcher("/index.jsp");
    						//����ת��
//    						rd.forward(request, response);
    						errMsg = "��̨ϵͳֻ�������Աʹ��";
    						break;
    					case 2:
    						rd = request.getRequestDispatcher("/managehead.jsp");
    						rd.forward(request, response);
    						break;
    					default:
    						System.out.println("DEFAULT");
    						errMsg = "״̬Ϊδ����,��ת�ص�¼����";
    						break;
    				}			
    			} else{
    				errMsg = "�û������������";
    			}
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if(errMsg != null && !errMsg.equals("")){
    		rd = request.getRequestDispatcher("/login.jsp");
    		request.setAttribute("err", errMsg);
    		rd.forward(request, response);
    	}
    }

}
