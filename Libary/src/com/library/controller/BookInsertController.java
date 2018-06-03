package com.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.Vo.BookVO;
import com.library.service.BookService;

public class BookInsertController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		BookService service = BookService.getInstance();
		String title = req.getParameter("bookname");
		String category = req.getParameter("category");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		String publication_Day = req.getParameter("publishyear");
		if(title.isEmpty() || category.isEmpty() || author.isEmpty() || publisher.isEmpty() ||
				publication_Day.isEmpty())
		{
			req.setAttribute("error","빈칸이 존재합니다.");
			HttpUtil.forward(req, res, "/bookadd.jsp");
			return;
		}
		BookVO book = new BookVO(title,category,author,publisher,publication_Day);
		service.BookInsertService(book);
		HttpUtil.forward(req, res,"/book.jsp");
		return;
	}

	
}
