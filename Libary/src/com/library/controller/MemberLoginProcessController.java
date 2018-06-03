package com.library.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.Vo.MemberVO;
import com.library.service.MemberService;

public class MemberLoginProcessController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberService service = MemberService.serviceGetInstance();
		String id = req.getParameter("e-mail");
		System.out.println("id = " + id);
		String pw = req.getParameter("pw");
		System.out.println("pw = " + pw);
		String pwChk = service.MemberLoginProcess(id);
		System.out.println("pwChk = " + pwChk);
		HttpSession s = req.getSession();
		System.out.println(s.getAttribute("Login"));
		if((req.getMethod()).equals("GET"))
		{
			s.removeAttribute("Login");
			HttpUtil.forward(req, res,"/index.jsp");
			return;
		}
		if(id == null)
		{
			System.out.println("id 는 null");
		}
		if(id.isEmpty() || pw.isEmpty())
		{
			req.setAttribute("emptyError","모두 입력해주세요.");
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
		
		else if(pw.equals(pwChk))
		{
			if(s.getAttribute("Login") != null)
			{
				req.setAttribute("overlapError","이미 로그인중입니다.");
				HttpUtil.forward(req, res,"/index.jsp");
				return;
			}
			MemberVO member = null;
			ArrayList<MemberVO> list = service.getList();
			for(MemberVO memberChk : list)
			{
				if((memberChk.getPwd()).equals(pwChk))
				{
					member = memberChk;
				}
				
			}
			s.setAttribute("Login",true);
			s.setAttribute("currentUser",member);
			HttpUtil.forward(req, res,"/user.jsp");
			return;
		}
		
		else
		{
			req.setAttribute("pwError","비밀번호가 틀립니다.");
			HttpUtil.forward(req, res,"/index.jsp");
			return;
		}
	}

}
