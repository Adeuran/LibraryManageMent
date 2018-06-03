package com.library.Vo;

public class MemberVO {

	private String name;
	private String email;
	private String address;
	private String phone;
	private String pwd;
	private int num;
	private int overdue = 0;
	private String overdue_Day;
	

	public MemberVO()
	{
		
	}	
	public MemberVO(String name, String email, String address, String phone, String pwd)
	{
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.pwd = pwd;
	}
	public MemberVO(String name, String email, String address, String phone, String pwd,int num)
	{
		this(name,email,address,phone,pwd);
		this.num = num;
	}
	
	public MemberVO(String name, String email, String address, String phone, String pwd,int num,int overdue)
	{
		this(name,email,address,phone,pwd,num);
		this.overdue = overdue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getOverdue() {
		return overdue;
	}

	public void setOverdue(int overdue) {
		this.overdue = overdue;
	}

	public String getOverdue_Day() {
		return overdue_Day;
	}

	public void setOverdue_Day(String overdue_Day) {
		this.overdue_Day = overdue_Day;
	}

	public static boolean memberChkOverdue(MemberVO member)
	{
		if(member.getOverdue() == 0)
		{
			return true;
		}
		
		else
		{
			return false;
			
		}
	}
}


