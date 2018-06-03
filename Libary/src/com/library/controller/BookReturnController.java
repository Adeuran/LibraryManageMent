package com.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.Vo.MemberVO;
import com.library.service.BookService;

public class BookReturnController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = req.getSession();
		BookService service = BookService.getInstance();
		MemberVO member = (MemberVO) s.getAttribute("currentUser") ;
		int bookNum = Integer.parseInt(req.getParameter("bookNum"));
		int userNum = member.getNum();
		service.bookReturnService(bookNum,userNum);
		HttpUtil.forward(req, res, "/bookReturn.jsp");
		return;
	}

	
}
