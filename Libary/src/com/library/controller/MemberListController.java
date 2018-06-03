package com.library.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.Vo.MemberVO;
import com.library.service.MemberService;

public class MemberListController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<MemberVO> list = null;
		MemberService service = MemberService.serviceGetInstance();
			list =  service.getList();
			req.setAttribute("List",list);
			HttpUtil.forward(req, res,"/user.jsp");
	}

	
}
