package com.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.memberVo.MemberVO;
import com.library.service.MemberService;

public class MemberUpdateController implements Controller{

	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		int num = Integer.parseInt(req.getParameter("num"));
		MemberService service = MemberService.serviceGetInstance();
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String pwd = req.getParameter("pw");
		MemberVO member = new MemberVO(name,email,address,phone,pwd);
		service.MemberUpdate(member,num);
		HttpUtil.forward(req, res, "/user.jsp");
	}
}
