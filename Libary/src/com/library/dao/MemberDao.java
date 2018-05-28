package com.library.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

import com.library.memberVo.MemberVO;
import java.sql.PreparedStatement;

public class MemberDao {
 
	private static boolean Idchk = false;
	private static MemberDao dao = new MemberDao();
	
	private MemberDao() {}
	
	public static MemberDao getInstance()
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
	
	public static boolean getIdchk()
	{
		return Idchk;
	}
	public void MemberInsert(MemberVO member)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		String id = member.getEmail();
		try
		{
			
			conn = connect();
			psmt = conn.prepareStatement("insert into member values(?,?,?,?,?)");
			// name /  email / address / phone / pwd
			ArrayList<MemberVO> list = memberList();
			for(int i = 0; i < list.size() ; i++)
			{
				MemberVO IdchkMember = list.get(i);
				if(id.equals(IdchkMember.getEmail()))
				{
					Idchk = true;
					return;
				}
			}
			Idchk = false;
			psmt.setString(1,member.getName());
			psmt.setString(2, member.getEmail());
			psmt.setString(3, member.getAddress());
			psmt.setString(4, member.getPhone());
			psmt.setString(5, member.getPwd());
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("MemberInsert 오류 발생" + e);
		}
		finally
		{
			close(conn,psmt);
		}
	}
	
	public MemberVO MemberSearch(String id)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		MemberVO member = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("select * from member where id = ?");
			psmt.setString(1,id);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				member = new MemberVO(rs.getString(1),
						rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5));
			}
		}
		catch(Exception e)
		{
			System.out.println("MemberSearch 오류 발생" + e);
		}
		finally
		{
			close(conn,psmt);
		}
		return member;
	}
	
	public void MemberUpdate(MemberVO member)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("update member set name = ?, address = ?, phone = ?, pw = ? where email = ?");
			// name /  email / address / phone / pw
			psmt.setString(1,member.getName());
			psmt.setString(2, member.getAddress());
			psmt.setString(3, member.getPhone());
			psmt.setString(4, member.getPwd());
			psmt.setString(5, member.getEmail());
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("MemberUpdate 오류 발생" + e);
		}
		finally
		{
			close(conn,psmt);
		}
	}
	
	public void MemberDelete(int num)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("delete from member where num = ?");
			psmt.setInt(1,num);
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("MemberDelete 오류 발생 " + e);
		}
		finally
		{
			close(conn,psmt);
		}
	}
	
	public ArrayList<MemberVO> memberList()
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		MemberVO member = null;
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		try 
		{
			conn = connect();
			psmt = conn.prepareStatement("select * from member");
			rs = psmt.executeQuery();
			while(rs.next())
			{
				member = new MemberVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				list.add(member);
			}
		}
		catch(Exception e)
		{
			System.out.println("memberlist 오류 발생 " + e);
		}
		return list;
		
	}
	
}
