package com.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.service.MemberService;

public class MemberLoginProcessController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberService service = MemberService.serviceGetInstance();
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String pwChk = service.MemberLoginProcess(id);
		HttpSession s = req.getSession();
		if((req.getMethod()).equals("GET"))
		{
			s.removeAttribute("Login");
			HttpUtil.forward(req, res,"/index.jsp");
			return;
		}
		if(id.equals(req.getAttribute("adminId")) && pw.equals(req.getAttribute("adminPw")))
		{
			HttpUtil.forward(req, res,"/adminMain.jsp");
			return;
		}
		if(pwChk == null)
		{
			req.setAttribute("idError","존재하지 않은 회원입니다.");
			HttpUtil.forward(req, res,"/index.jsp");
			return;
		}
		
		else if(pw == pwChk)
		{
			s.setAttribute("Login",true);
			HttpUtil.forward(req, res,"/userMain.jsp");
			return;
		}
		
	}

}
