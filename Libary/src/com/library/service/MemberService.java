package com.library.service;

import com.library.dao.MemberDao;
import com.library.memberVo.MemberVO;

public class MemberService {

	private static MemberService service = new MemberService();
	private MemberService() {};
	
	MemberDao dao = MemberDao.getInstance();
	
	public void MemberInsert(MemberVO member)
	{
		dao.MemberInsert(member);
	}
	
	public MemberVO MemberSearch(String id)
	{
		return dao.MemberSearch(id);
	}
	public void MemberUpdate(MemberVO member)
	{
		dao.MemberInsert(member);
	}
	
	public void MemberDelete(int num)
	{
		dao.MemberDelete(num);
	}
}
