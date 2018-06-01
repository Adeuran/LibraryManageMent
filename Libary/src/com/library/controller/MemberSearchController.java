package com.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.Vo.MemberVO;
import com.library.service.MemberService;

public class MemberSearchController implements Controller{

	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		String id = req.getParameter("searchBox");
		MemberService service = MemberService.serviceGetInstance();
		MemberVO member = null;
		member = service.MemberSearch(id);
		if(member != null)
			req.setAttribute("searchMember",member);
		else
		{
			req.setAttribute("error","해당 회원은 존재하지 않습니다.");
		}
		HttpUtil.forward(req, res, "/user.jsp");
	}
}
