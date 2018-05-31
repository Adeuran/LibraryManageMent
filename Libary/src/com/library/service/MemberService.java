package com.library.service;

import java.util.ArrayList;

import com.library.dao.MemberDao;
import com.library.memberVo.MemberVO;

public class MemberService {

	private static MemberService service = new MemberService();
	private MemberService() {};
	public static MemberService serviceGetInstance()
	{
		return service;
	}
	MemberDao dao = MemberDao.getInstance();
	private ArrayList<MemberVO> list = dao.memberList();
	public void MemberInsert(MemberVO member)
	{
		dao.MemberInsert(member);
	}
	
	public MemberVO MemberSearch(String id)
	{
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
		return list;
	}
	
	public String MemberLoginProcess(String id)
	{
		return dao.MemberLoginProcess(id);
	}
}
