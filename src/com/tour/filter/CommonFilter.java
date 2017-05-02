package com.tour.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//����������,����Ĭ���ַ������δ��¼ʱ�����ʼҳ��
@WebFilter(filterName="common"
		,urlPatterns={"*.jsp"}
		,initParams={
			@WebInitParam(name="encoding", value="utf-8"),
			@WebInitParam(name="text",value="text/html;charset=utf-8"),
			@WebInitParam(name="reg",value="/reg.jsp"),
			@WebInitParam(name="checkCode",value="PicCheckCode"),
			@WebInitParam(name="loginServlet",value="LoginServlet"),
			@WebInitParam(name="login", value="/login.jsp")})
public class CommonFilter implements Filter{
	
	//���ڷ���Filter��������Ϣ
	private FilterConfig config;

	@Override
	public void destroy() {
		this.config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String encoding = config.getInitParameter("encoding");
		String loginPage = config.getInitParameter("login");
		String regPage = config.getInitParameter("reg");
		String checkCode = config.getInitParameter("checkCode");
		String loginServlet = config.getInitParameter("LoginServlet");
		//����request�����õ��ַ���
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		HttpServletRequest requ = (HttpServletRequest) request;
		HttpSession session = requ.getSession(true);
		//��ȡ�û������ҳ��
		String requestPath = requ.getServletPath();
		//���session��userΪnull,������û�е�¼
		//���û������Ҳ���ǵ�¼���棬�Ǿ�forward����¼ҳ��
		if(session.getAttribute("userName") == null
				&& !requestPath.endsWith(loginPage)
				&& !requestPath.endsWith(regPage)){
			request.setAttribute("err", "�㻹û�е�¼");
			request.getRequestDispatcher(loginPage).forward(request, response);
		} else{
			//�����������
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.config = arg0;
	}

}
