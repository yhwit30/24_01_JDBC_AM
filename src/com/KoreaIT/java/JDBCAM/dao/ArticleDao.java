package com.KoreaIT.java.JDBCAM.dao;

import java.sql.Connection;

import com.KoreaIT.java.JDBCAM.util.DBUtil;
import com.KoreaIT.java.JDBCAM.util.SecSql;

public class ArticleDao {

	public int dbInsert(Connection conn, SecSql sql) {
		int id = DBUtil.insert(conn, sql);
		return id;
	}

}
