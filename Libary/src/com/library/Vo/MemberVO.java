package com.library.Vo;

public class MemberVO {

	private String name;
	private String email;
	private String address;
	private String phone;
	private String pwd;
	private int num;
	private String overdue;
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

	public String getOverdue() {
		return overdue;
	}

	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}

	public String getOverdue_Day() {
		return overdue_Day;
	}

	public void setOverdue_Day(String overdue_Day) {
		this.overdue_Day = overdue_Day;
	}
	
}
