package com.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.Vo.MemberVO;
import com.library.service.BookService;

public class BookBorrowController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = req.getSession();
		MemberVO member = null; 
		if(s.getAttribute("currentUser") != null)
		{
			member = (MemberVO) s.getAttribute("currentUser");
		}
		if(MemberVO.memberChkOverdue(member) == false)
		{
			req.setAttribute("error","현재 연체중입니다.");
			HttpUtil.forward(req, res,"/bookRental.jsp");
			return;
		}
		int num = Integer.parseInt(req.getParameter("num"));
		BookService service = BookService.getInstance();
		service.BookBorrowService(member,num);
		HttpUtil.forward(req, res,"/bookRentalOutput.jsp");
	}

	
}
