package com.library.service;

import java.util.ArrayList;

import com.library.Vo.BookVO;
import com.library.Vo.MemberVO;
import com.library.dao.BookDao;

public class BookService {

	private static BookService service = new BookService();
	private static BookDao dao = BookDao.getInstance();
	private BookService() {}
	
	public static BookService getInstance() 
	{
		return service;
	}
	
	public void BookInsertService(BookVO book)
	{
		dao.bookInsert(book);
	}
	
	public ArrayList<BookVO> BookSearchService(String title)
	{
		return dao.bookSearch(title);
	}
	public void BookUpdateService(BookVO book, int num)
	{
		dao.BookUpdate(book,num);
	}
	
	public void BookDeleteService(int num)
	{
		dao.BookDelete(num);
	}
	
	public void BookBorrowService(MemberVO member, int num)
	{
		dao.BookBorrow(member, num);
	}
	
	public ArrayList<BookVO> BookListService()
	{
		return dao.BookList();
	}
	
	public void bookReturnService(int num)
	{
		dao.bookReturn(num);
	}
	
	public static ArrayList<BookVO> borrowBookListService(int num)
	{
		return dao.borrowBookList(num);
	}
	
	public void judgeOverdueService(int num)
	{
		dao.judgeOverdue(num);
	}
}
