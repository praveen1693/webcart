package com.webcart.entity;

public class Member {
	
	private String userName;
	private String name;
	private String phNo;
	private String mailId;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Member(String userName, String name, String phNo, String mailId, String password) {
		super();
		this.userName = userName;
		this.name = name;
		this.phNo = phNo;
		this.mailId = mailId;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Member [userName=" + userName + ", name=" + name + ", phNo=" + phNo + ", mailId=" + mailId
				+ ", password=" + password + "]";
	}
	public Member(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
	
}
