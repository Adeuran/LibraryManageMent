package com.library.memberVo;

public class MemberVO {

	private String name;
	private String email;
	private String address;
	private String phone;
	private String pwd;
	private int num;
	
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName()
	{
		return name;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public String getPwd()
	{
		return pwd;
	}
}
