package com.KoreaIT.java.JDBCAM.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.JDBCAM.dao.ArticleDao;

public class ArticleService {

	private ArticleDao articleDao;

	public ArticleService(Connection conn) {
		this.articleDao = new ArticleDao(conn);
	}

	public int doWrite(String title, String body) {

		return articleDao.doWrite(title, body);
	}

	public List<Map<String, Object>> showList() {

		return articleDao.showList();
	}

	public Map<String, Object> getRowById(int id) {

		return articleDao.getRowById(id);
	}

	public void doModify(int id, String title, String body) {

		articleDao.doModify(id, title, body);

	}

	public void doDelete(int id) {
		articleDao.doDelete(id);

	}

}
