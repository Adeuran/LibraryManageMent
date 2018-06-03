package com.library.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

import com.library.Vo.MemberVO;

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
			// name /  email / address / phone / pwd
			ArrayList<MemberVO> list = memberList();
			for(int i = 0; i < list.size() ; i++)
			{
				MemberVO IdchkMember = list.get(i);
				System.out.println("member id : " + id);
				System.out.println("chkMember id : " + IdchkMember.getEmail());
				if(id.equals(IdchkMember.getEmail()))
				{
					Idchk = true;
					return;
				}
			}
			Idchk = false;
			psmt = conn.prepareStatement("insert into member (name,email,address,phone,pw) values(?,?,?,?,?)");
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
			psmt = conn.prepareStatement("select * from member where email = ?");
			psmt.setString(1,id);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				member = new MemberVO(rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(1));
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
	
	public void MemberUpdate(MemberVO member,int num)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("update member set name = ?, address = ?, phone = ?, pw = ? where num = ?");
			// name /  email / address / phone / pw
			psmt.setString(1,member.getName());
			psmt.setString(2, member.getAddress());
			psmt.setString(3, member.getPhone());
			psmt.setString(4, member.getPwd());
			psmt.setInt(5, num);
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
			psmt = conn.prepareStatement("select name,email,address,phone,pw,num from member");
			rs = psmt.executeQuery();
			while(rs.next())
			{
				member = new MemberVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
				list.add(member);
			}
		}
		catch(Exception e)
		{
			System.out.println("memberlist 오류 발생 " + e);
		}
		
		finally
		{
			close(conn,psmt);
		}
		return list;
		
	}
	
	public String MemberLoginProcess(String id)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String pw = null;
		try
		{
			conn = connect();
			System.out.println("Login 시작");
			System.out.println("id in dao : " +id);
			psmt = conn.prepareStatement("select pw from member where email = ?");
			System.out.println("Login rs 시작");
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				System.out.println("Login rs 시작");
				pw = rs.getString(1);
				System.out.println("pw in dao : " + pw);
			}
		}
		catch(Exception e)
		{
			System.out.println("exception 발생 : " + e);
		}
		
		finally
		{
			close(conn,psmt);
		}
		return pw;
	}
	
	public void MemberOverdueSet(int num, long overdueDay)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("update member set overdue = ?, overdue_Day = ? where num = ? ");
			psmt.setInt(1,1);
			psmt.setLong(2,overdueDay);
			psmt.setInt(3,num);
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			close(conn,psmt);
		}
	}
}
