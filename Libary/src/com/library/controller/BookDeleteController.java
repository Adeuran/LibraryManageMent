package com.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.service.BookService;

public class BookDeleteController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookService service = BookService.getInstance();
		int num = Integer.parseInt(req.getParameter("bookNum"));
		service.BookDeleteService(num);
		HttpUtil.forward(req, res,"/book.jsp");
	}
}
