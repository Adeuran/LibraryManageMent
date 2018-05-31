package com.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.service.MemberService;

public class MemberDeleteController implements Controller{

	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		int num = Integer.parseInt(req.getParameter("num"));
		MemberService service = MemberService.serviceGetInstance();
		service.MemberDelete(num);
		HttpUtil.forward(req, res, "/user.jsp");
	}
}
