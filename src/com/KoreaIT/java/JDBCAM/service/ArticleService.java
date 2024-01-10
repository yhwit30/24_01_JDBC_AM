package com.KoreaIT.java.JDBCAM.service;

import java.sql.Connection;

import com.KoreaIT.java.JDBCAM.dao.ArticleDao;
import com.KoreaIT.java.JDBCAM.util.DBUtil;
import com.KoreaIT.java.JDBCAM.util.SecSql;

public class ArticleService {
	ArticleDao articleDao = new ArticleDao();

	public int dbInsert(Connection conn, SecSql sql) {
		
		int id = articleDao.dbInsert(conn, sql);
		
		return id;
	}

}
