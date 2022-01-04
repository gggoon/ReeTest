package com.koreait.test2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.test2.dao.MemberDAO;
import com.koreait.test2.dto.Member;

public class MemberTest {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void joinTest() {
		Member member = new Member();
		member.setId("testId");
		member.setPw("testPw");
		member.setName("testName");
		member.setEmail("testId@web.com");
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		assertEquals("member 가입 실패", 1, memberDAO.join(member));
	}
	
	@Test
	public void idCheckTest() {
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		assertEquals("member id 조회 실패", 1, memberDAO.idCheck("admin"));
	}

	@Test
	public void loginTest() {
		Member member = new Member();
		member.setId("admin");
		member.setPw("1111");
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		assertNotNull("member id, pw 조회 실패", memberDAO.login(member));
	}
	
	@Test
	public void leaveTest() {
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		assertEquals("member 탈퇴 실패", 1, memberDAO.leave(10000L));
	}
	
}



















