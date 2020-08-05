package com.model.vo;

import java.sql.Date;

public class Emp {
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String email;
	private String address;
	private String phone;
	private Date enrollDate;
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	
	public Emp(int memberNo, String memberId, String memberPwd, String memberName, String email, String address,
			String phone, Date enrollDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.enrollDate = enrollDate;
	}

	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Emp [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName="
				+ memberName + ", email=" + email + ", address=" + address + ", phone=" + phone + ", enrollDate="
				+ enrollDate + "]";
	}
}
