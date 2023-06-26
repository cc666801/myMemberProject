package com.example.MyMemberProject.model.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.MyMemberProject.model.dtos.MemberDto;

@Document(collection = "Member")
public class Member {

	@Id
	private String id;
	@Indexed(unique = true)
	private String email;
	private String password;

	// constructors
	public Member(MemberDto memberDto) {
		this.id = memberDto.getId();
		this.email = memberDto.getEmail();
		this.password = memberDto.getPassword();
	}
	
	public Member() {
		super();
	}


	// getters and setters
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
		return "Member [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

	
}
