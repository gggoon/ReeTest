package com.koreait.test2.dto;

import java.sql.Date;

public class Member {
	
	private Long no;
	private String id;
	private String pw;
	private String name;
	private String email;
	private Date regdate;
	
	public Member() {
		super();
	}
	public Member(Long no, String id, String pw, String name, String email, Date regdate) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.regdate = regdate;
	}
	
}
