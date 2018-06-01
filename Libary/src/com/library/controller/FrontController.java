package com.library.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.controller.Controller;

public class FrontController extends HttpServlet{
	String adminId;
	String adminPw;
	
	HashMap<String,Controller> list = null;
	public void init(ServletConfig config) throws ServletException
	{
		list = new HashMap<String, Controller>();
		adminId = config.getInitParameter("adminId");
		adminPw = config.getInitParameter("adminPw");
		list.put("/memberInsert.do",new MemberInsertController());
		list.put("/memberSearch.do",new MemberSearchController());
		list.put("/memberUpdate.do",new MemberUpdateController());
		list.put("/memberDelete.do",new MemberDeleteController());
		list.put("/memberLoginProcess.do",new MemberLoginProcessController());
		list.put("/bookInsert.do",new BookInsertController());
		list.put("/bookSearch.do",new BookSearchController());
		list.put("/bookUpdate.do",new BookUpdateController());
		list.put("/bookDelete.do",new BookUpdateController());
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String url = request.getRequestURI(); 
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		System.out.println("path : " + path);
		Controller subController = list.get(path);
		request.setAttribute("adminId", adminId);
		request.setAttribute("adminPw", adminPw);
		subController.execute(request, response);
	}
}
