package com.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.memberVo.MemberVO;
import com.library.service.MemberService;

public class MemberSearchController implements Controller{

	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		String id = req.getParameter("id");
		MemberService service = MemberService.serviceGetInstance();
		MemberVO member = null;
		member = service.MemberSearch(id);
		req.setAttribute("searchMember",member);
		HttpUtil.forward(req, res, "/user.jsp");
	}
}
