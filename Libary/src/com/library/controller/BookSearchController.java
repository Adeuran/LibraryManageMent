package com.library.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.Vo.BookVO;
import com.library.service.BookService;

public class BookSearchController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookService service = BookService.getInstance();
		String title = (String) req.getParameter("searchBox");
		ArrayList<BookVO> books = null;
		try
		{
			books = service.BookSearchService(title);
		}
		catch(Exception e)
		{
			System.out.println("SearchController 오류 발생 : " + e);
		}
		req.setAttribute("book",books);
		HttpUtil.forward(req, res,"/book.jsp");
	}

}
