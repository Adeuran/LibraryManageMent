package com.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.Vo.BookVO;
import com.library.service.BookService;

public class BookUpdateController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BookService service = BookService.getInstance();
		BookVO book = null;
		req.setCharacterEncoding("UTF-8");
		int num = Integer.parseInt(req.getParameter("num"));
		String title = req.getParameter("bookname");
		String category = req.getParameter("category");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		String publication_Day = req.getParameter("publishyear");
		//int borrow_Idnum = Integer.parseInt(req.getParameter("borrow_Idnum"));
		//String borrow_Day = req.getParameter("borrow_Day");
		if(title.isEmpty() || category.isEmpty() || author.isEmpty() || publisher.isEmpty() ||
				publication_Day.isEmpty()/*(req.getParameter("borrow_Idnum")).isEmpty() || borrow_Day.isEmpty()*/)
		{
			req.setAttribute("error", "빈칸이 존재합니다.");
			HttpUtil.forward(req, res, "/bookUpdate.jsp");
			return;
		}
		book = new BookVO(title,category,author,publisher,publication_Day);
		//book.setBorrow_Idnum(borrow_Idnum);
		//book.setBorrow_Day(borrow_Day);
		service.BookUpdateService(book, num);
		HttpUtil.forward(req, res, "/book.jsp");
		return;
	}

	
}
