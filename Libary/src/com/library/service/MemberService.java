package com.library.service;

import java.util.ArrayList;

import com.library.Vo.MemberVO;
import com.library.dao.MemberDao;

public class MemberService {

	private static MemberService service = new MemberService();
	private MemberService() {};
	public static MemberService serviceGetInstance()
	{
		return service;
	}
	MemberDao dao = MemberDao.getInstance();
	public void MemberInsert(MemberVO member)
	{
		dao.MemberInsert(member);
	}
	
	public MemberVO MemberSearch(String id)
	{
		if(dao.MemberSearch(id) != null)
			System.out.println((dao.MemberSearch(id)).getAddress());
		else
		{
			System.out.println("회원 존재 x");
		}
		return dao.MemberSearch(id);
	}
	public void MemberUpdate(MemberVO member,int num)
	{
		dao.MemberUpdate(member,num);
	}
	
	public void MemberDelete(int num)
	{
		dao.MemberDelete(num);
	}
	
	public ArrayList<MemberVO> getList()
	{
		return dao.memberList();
	}
	
	public String MemberLoginProcess(String id)
	{
		return dao.MemberLoginProcess(id);
	}
}
