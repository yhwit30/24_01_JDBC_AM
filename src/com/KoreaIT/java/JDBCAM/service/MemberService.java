package com.KoreaIT.java.JDBCAM.service;

import java.sql.Connection;

import com.KoreaIT.java.JDBCAM.dao.MemberDao;

public class MemberService {

	private MemberDao memberDao;

	public MemberService(Connection conn) {
		this.memberDao = new MemberDao(conn);
	}

	public boolean isLoginIdDup(String loginId) {
		return memberDao.isLoginIdDup(loginId);
	}

	public int doJoin(String loginId, String loginPw, String name) {
		
		return memberDao.doJoin(loginId,loginPw,name);
	}

	public String getLoginedName(String loginId) {
		return memberDao.getLoginedName(loginId);
	}

	public boolean isLoginPwCorrect(String loginId, String loginPw) {
		
		
		String dbLoginPw = memberDao.isLoginPwCorrect(loginId);
		
		if (dbLoginPw.equals(loginPw)) {
			return true;
		}
		
		return false;
	}

}