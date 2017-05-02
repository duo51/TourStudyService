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

//公共过滤器,设置默认字符编码和未登录时候的起始页面
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
	
	//用于访问Filter的配置信息
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
		//设置request编码用的字符集
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		HttpServletRequest requ = (HttpServletRequest) request;
		HttpSession session = requ.getSession(true);
		//获取用户请求的页面
		String requestPath = requ.getServletPath();
		//如果session的user为null,即表名没有登录
		//且用户请求的也不是登录界面，那就forward到登录页面
		if(session.getAttribute("userName") == null
				&& !requestPath.endsWith(loginPage)
				&& !requestPath.endsWith(regPage)){
			request.setAttribute("err", "你还没有登录");
			request.getRequestDispatcher(loginPage).forward(request, response);
		} else{
			//否则请求放行
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.config = arg0;
	}

}
