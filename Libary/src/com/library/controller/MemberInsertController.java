package com.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.Vo.MemberVO;
import com.library.dao.MemberDao;
import com.library.service.MemberService;

public class MemberInsertController implements Controller{

	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		// name /  email / address / phone / pwd
		req.setCharacterEncoding("UTF-8");
		MemberService service = MemberService.serviceGetInstance();
		String name = req.getParameter("name");
		String email  = req.getParameter("e-mail");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String pwd = req.getParameter("pw");
		System.out.println("name : " + name + "pwd : " + pwd);
		if(email.isEmpty()||name.isEmpty()||address.isEmpty()||phone.isEmpty()||pwd.isEmpty())
		{
			req.setAttribute("error","모든 칸을 입력해주세요");
			HttpUtil.forward(req, res,"/useradd.jsp");
			return;
		}
		MemberVO member = new MemberVO(name, email, address, phone, pwd);
		service.MemberInsert(member);
		if(MemberDao.getIdchk())
		{
			req.setAttribute("error","중복된 아이디가 있습니다.");
			HttpUtil.forward(req, res,"/useradd.jsp");
			return;
		}
		else
		{
			req.setAttribute("msg", "회원가입 성공");
			HttpUtil.forward(req, res,"/user.jsp");
			return;
		}
	}
}
