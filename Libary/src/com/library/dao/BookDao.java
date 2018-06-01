package com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.library.Vo.BookVO;

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
	
	public BookVO bookSearch(String title)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		BookVO book = null;
		
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("select * from book where title = ?");
			psmt.setString(1, title);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				book = new BookVO(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				book.setNum(rs.getInt(1));
				book.setBorrow_Idnum(rs.getString(7));
				book.setBorrow_Day(rs.getString(8));
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
		return book;
	}
	
	public void BookUpdate(BookVO book,int num)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("update book set title = ?, category = ?, author = ?, publisher = ?,"
					+ "publication_Day = ?, borrow_Idnum = ?, borrow_Day = ?  where num = ?");
			psmt.setString(1,book.getTitle());
			psmt.setString(2, book.getCategory());
			psmt.setString(3,book.getAuthor());
			psmt.setString(4, book.getPublisher());
			psmt.setString(5, book.getPublication_Day());
			psmt.setString(6, book.getBorrow_Idnum());
			psmt.setString(6, book.getBorrow_Day());
			psmt.setInt(8,num);
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
			psmt = conn.prepareStatement("delete * from book where num = ?");
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
}
