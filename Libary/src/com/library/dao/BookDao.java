package com.library.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.library.Vo.BookVO;
import com.library.Vo.MemberVO;
import com.library.service.BookService;

public class BookDao {

	private static BookDao dao = new BookDao();
	private BookDao() {}
	
	public static BookDao getInstance() 
	{
		return dao;
	}
	
	public Connection connect()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/library";
			String user = "root";
			String pwd = "cs1234";
			conn = DriverManager.getConnection(url,user,pwd);
		}
		catch(Exception e)
		{
			System.out.println("Connenction 오류발생 : " + e);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement psmt)
	{
		if(psmt != null)
		{
			try
			{
				psmt.close();
			}
			catch(Exception e)
			{
				System.out.println("close : psmt 오류 발생 : " + e);
			}
		}
		
		if(conn != null)
		{
			try
			{
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println("close : conn 오류 발생 : " + e);
			}
		}
	}
	
	public void bookInsert(BookVO book)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("insert into book (title,category,author,publisher,publication_Day) values(?,?,?,?,?)");
			psmt.setString(1,book.getTitle());
			psmt.setString(2, book.getCategory());
			psmt.setString(3, book.getAuthor());
			psmt.setString(4,book.getPublisher());
			psmt.setString(5, book.getPublication_Day());
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Insert오류 발생 : " +e);
		}
		finally
		{
			close(conn,psmt);
		}
	}
	
	public ArrayList<BookVO> bookSearch(String title)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		BookVO book = null;
		ArrayList<BookVO> list = null;
		
		try
		{
			list = new ArrayList<BookVO>();
			conn = connect();
			psmt = conn.prepareStatement("select * from book where title = ?");
			psmt.setString(1, title);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				book = new BookVO(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(1));
				book.setNum(rs.getInt(1));
				book.setBorrow_Idnum(rs.getInt(7));
				book.setBorrow_Day(rs.getString(8));
				list.add(book);
			}
		}
		catch(Exception e)
		{
			System.out.println("update 오류 : " + e);
		}
		
		finally
		{
			close(conn,psmt);
		}
		return list;
	}
	
	public void BookUpdate(BookVO book,int num)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("update book set title = ?, category = ?, author = ?, publisher = ?,"
					+ "publication_Day = ? where num = ?");
			psmt.setString(1,book.getTitle());
			psmt.setString(2, book.getCategory());
			psmt.setString(3,book.getAuthor());
			psmt.setString(4, book.getPublisher());
			psmt.setString(5, book.getPublication_Day());
			/*psmt.setInt(6, book.getBorrow_Idnum());
			psmt.setString(6, book.getBorrow_Day());*/
			psmt.setInt(6,num);
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("update 오류 발생 : " + e);
		}
		finally
		{
			close(conn,psmt);
		}
	}
	
	public void BookDelete(int num)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("delete from book where num = ?");
			psmt.setInt(1,num);
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("delete 오류 발생 : " + e);
		}
		finally
		{
			close(conn,psmt);
		}
	}
	
	public ArrayList<BookVO> BookList()
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		BookVO book = null;
		ArrayList<BookVO> list = null;
		try
		{
			list = new ArrayList<BookVO>();
			conn = connect();
			psmt = conn.prepareStatement("select * from book");
			rs = psmt.executeQuery();
			while(rs.next())
			{
				book = new BookVO(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(1));
				book.setBorrow(rs.getInt(9));
				list.add(book);
			}
		}
		
		catch(Exception e)
		{
			System.out.println("bookList 오류 발생 : " + e);
		}
		
		finally
		{
			close(conn,psmt);
		}
		
		return list;
	}
	public void BookBorrow(MemberVO member,int num)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		String inDate   = new java.text.SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date());
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("update book set borrow = ?, borrow_Idnum = ?,borrow_Day = ? where num = ?");
			psmt.setInt(1,1);
			psmt.setInt(2, member.getNum());
			psmt.setString(3, inDate);
			psmt.setInt(4, num);
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("BookBorrow 오류 발생 :" + e);
		}
		
		finally
		{
			close(conn,psmt);
		}
	}
	
	public void bookReturn(int num)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("update book set borrow = ?, borrow_Idnum = ?,borrow_Day = ? where num = ?");
			psmt.setInt(1,0);
			psmt.setInt(2,0);
			psmt.setString(3,null);
			psmt.setInt(4, num);
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("BookBorrow 오류 발생 :" + e);
		}
		
		finally
		{
			close(conn,psmt);
		}
	}
	
	public ArrayList<BookVO> borrowBookList(int num)
	{
	
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		BookVO book = null;
		ArrayList<BookVO> list = null;
		try
		{
			list = new ArrayList<BookVO>();
			conn = connect();
			psmt = conn.prepareStatement("select * from book where borrow_Idnum = ?");
			psmt.setInt(1,num);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				book = new BookVO(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(1));
				book.setBorrow_Idnum(rs.getInt(7));
				book.setBorrow_Day(rs.getString(8));
				book.setBorrow(rs.getInt(9));
				list.add(book);
			}
		}
		
		catch(Exception e)
		{
			System.out.println("borrowBookList 오류 발생 : " + e);
		}
		
		finally
		{
			close(conn,psmt);
		}
		
		return list;
	}
	
	public void judgeOverdue(int num) //유저 num
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		ArrayList<BookVO> list = null;
		BookService service = BookService.getInstance();
		try
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd");
			String inDate   = new java.text.SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date());
			list = service.borrowBookListService(num);
			conn = connect();
			for(BookVO book : list)
			{
				Date borrowDate = (Date) format.parse(book.getBorrow_Day());
				Date todayDate = (Date) format.parse(inDate);
				
				long calOverdue = (todayDate.getTime() - borrowDate.getTime()) / (24*60*60*1000) - 7;
				System.out.println("지난 날짜 : " + calOverdue);
				if(calOverdue > 0)
				{
					MemberDao dao = MemberDao.getInstance();
					dao.MemberOverdueSet(num, (int) calOverdue);
					return;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("calOverdue 오류 발생 : " + e);
		}
		
		finally
		{
			close(conn,psmt);
		}
	}
}
