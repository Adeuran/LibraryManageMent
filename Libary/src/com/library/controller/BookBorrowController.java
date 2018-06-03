package com.library.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.Vo.MemberVO;
import com.library.service.BookService;
import com.library.service.MemberService;

public class BookBorrowController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = req.getSession();
		MemberVO member = null;
		String current_Id = (String) s.getAttribute("currentUser_Id");
		MemberService service = MemberService.serviceGetInstance();
		ArrayList<MemberVO> list = service.getList();
		for(MemberVO memberChk : list)
		{
			if((memberChk.getEmail()).equals(current_Id))
			{
				member = memberChk;
				break;
			}
			
		}
		/*if(s.getAttribute("currentUser") != null)
		{
			member = (MemberVO) s.getAttribute("currentUser");
		}*/
		System.out.println("연체 상태 : " + MemberVO.memberChkOverdue(member));
		if(MemberVO.memberChkOverdue(member) == false)
		{
			req.setAttribute("error","현재 연체중입니다.");
			HttpUtil.forward(req, res,"/bookRental.jsp");
			return;
		}
		int num = Integer.parseInt(req.getParameter("num"));
		BookService service_2 = BookService.getInstance();
		service_2.BookBorrowService(member,num);
		HttpUtil.forward(req, res,"/bookRental.jsp");
	}

	
}
