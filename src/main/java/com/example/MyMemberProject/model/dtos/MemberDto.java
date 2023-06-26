package com.example.MyMemberProject.model.dtos;

import com.example.MyMemberProject.model.beans.Member;

public class MemberDto {
	private String id;
	private String email;
	private String password;
	
	public MemberDto(Member member) {
		this.id = member.getId();
		this.email = member.getEmail();
	}
	
	public MemberDto() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
