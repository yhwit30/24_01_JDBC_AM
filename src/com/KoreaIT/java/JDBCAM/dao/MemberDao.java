package com.KoreaIT.java.JDBCAM.dao;

import java.sql.Connection;

import com.KoreaIT.java.JDBCAM.util.DBUtil;
import com.KoreaIT.java.JDBCAM.util.SecSql;

public class MemberDao {
	private Connection conn;

	public MemberDao(Connection conn) {
		this.conn = conn;
	}

	public boolean isLoginIdDup(String loginId) {
		SecSql sql = new SecSql();
		sql.append("SELECT COUNT(*) > 0");
		sql.append("FROM `member`");
		sql.append("WHERE loginId = ?;", loginId);

		return DBUtil.selectRowBooleanValue(conn, sql);
	}

	public int doJoin(String loginId, String loginPw, String name) {
		SecSql sql = new SecSql();
		sql.append("INSERT INTO `member`");
		sql.append("SET regDate = NOW(),");
		sql.append("updateDate = NOW(),");
		sql.append("loginId = ?,", loginId);
		sql.append("loginPw = ?,", loginPw);
		sql.append("`name` = ?;", name);

		return DBUtil.insert(conn, sql);
	}

	public String getLoginedName(String loginId) {
		SecSql sql = new SecSql();
		sql.append("SELECT `name`");
		sql.append("FROM `member`");
		sql.append("WHERE loginId = ?;", loginId);

		String name = DBUtil.selectRowStringValue(conn, sql);

		return name;
	}

	public String isLoginPwCorrect(String loginId) {

		SecSql sql = new SecSql();
		sql.append("SELECT loginPw");
		sql.append("FROM `member`");
		sql.append("WHERE loginId = ?;", loginId);

		String dbLoginPw = DBUtil.selectRowStringValue(conn, sql);

		return dbLoginPw;
	}

}