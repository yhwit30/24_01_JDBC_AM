//package com.KoreaIT.java.JDBCAM.controller;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import com.KoreaIT.java.JDBCAM.Article;
//
//public class ArticleController {
//	int lastArticleId = 0;
//
//	public void doWrite(Scanner sc) {
//		System.out.println("==글쓰기==");
//		int id = lastArticleId + 1;
//		System.out.print("제목 : ");
//		String title = sc.nextLine();
//		System.out.print("내용 : ");
//		String body = sc.nextLine();
//
//		lastArticleId = id;
//
//		System.out.println(id + "번 글이 등록되었습니다");
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://127.0.0.1:3306/JDBC_AM?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
//
//			conn = DriverManager.getConnection(url, "root", "");
//			System.out.println("연결 성공!");
//
//			String sql = "INSERT INTO article ";
//			sql += "SET regDate = NOW(),";
//			sql += "updateDate = NOW(),";
//			sql += "title = '" + title + "',";
//			sql += "`body`= '" + body + "';";
//
//			System.out.println(sql);
//
//			pstmt = conn.prepareStatement(sql);
//
//			int affectedRow = pstmt.executeUpdate();
//
//			System.out.println("affectedRow : " + affectedRow);
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 실패");
//		} catch (SQLException e) {
//			System.out.println("에러 : " + e);
//		} finally {
//			try {
//				if (conn != null && !conn.isClosed()) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (pstmt != null && !pstmt.isClosed()) {
//					pstmt.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	public void showList() {
//		System.out.println("==목록==");
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		List<Article> articles = new ArrayList<>();
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://127.0.0.1:3306/JDBC_AM?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
//
//			conn = DriverManager.getConnection(url, "root", "");
//			System.out.println("연결 성공!");
//
//			String sql = "SELECT *";
//			sql += " FROM article";
//			sql += " ORDER BY id DESC;";
//
//			System.out.println(sql);
//
//			pstmt = conn.prepareStatement(sql);
//
//			rs = pstmt.executeQuery(sql);
//
//			while (rs.next()) {
//				int id = rs.getInt("id");
//				String regDate = rs.getString("regDate");
//				String updateDate = rs.getString("updateDate");
//				String title = rs.getString("title");
//				String body = rs.getString("body");
//
//				Article article = new Article(id, regDate, updateDate, title, body);
//
//				articles.add(article);
//
//			}
////			for (int i = 0; i < articles.size(); i++) {
////				System.out.println("번호 : " + articles.get(i).getId());
////				System.out.println("등록 날짜 : " + articles.get(i).getRegDate());
////				System.out.println("수정 날짜 : " + articles.get(i).getUpdateDate());
////				System.out.println("제목 : " + articles.get(i).getTitle());
////				System.out.println("내용 : " + articles.get(i).getBody());
////			}
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 실패");
//		} catch (SQLException e) {
//			System.out.println("에러 : " + e);
//		} finally {
//			try {
//				if (rs != null && !rs.isClosed()) {
//					rs.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (pstmt != null && !pstmt.isClosed()) {
//					pstmt.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (conn != null && !conn.isClosed()) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		if (articles.size() == 0) {
//			System.out.println("게시글이 없습니다");
//			return;
//		}
//
//		System.out.println("  번호  /   제목  ");
//		for (Article article : articles) {
//			System.out.printf("  %d     /   %s   \n", article.getId(), article.getTitle());
//		}
//	}
//
//	public void doModify(String cmd) {
//		int searchId = 0;
//		try {
//			searchId = Integer.parseInt(cmd.substring("article modify".length()).trim());
//		} catch (Exception e) {
//			System.out.println("정수 입력 바랍니다.");
//			return;
//		}
//
//		System.out.println("==목록==");
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		List<Article> articles = new ArrayList<>();
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://127.0.0.1:3306/JDBC_AM?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
//
//			conn = DriverManager.getConnection(url, "root", "");
//			System.out.println("연결 성공!");
//
//			String sql = "SELECT *";
//			sql += " FROM article";
//			sql += " WHERE id = " + searchId + ";";
//
//			System.out.println(sql);
//
//			pstmt = conn.prepareStatement(sql);
//
//			rs = pstmt.executeQuery(sql);
//
//			while (rs.next()) {
//				int id = rs.getInt("id");
//				String regDate = rs.getString("regDate");
//				String updateDate = rs.getString("updateDate");
//				String title = rs.getString("title");
//				String body = rs.getString("body");
//
//				Article article = new Article(id, regDate, updateDate, title, body);
//
//				articles.add(article);
//
//			}
//
//			System.out.println("==기존 게시글==");
//			System.out.println("  번호  /   제목  ");
//			for (Article article : articles) {
//				System.out.printf("  %d     /   %s   \n", article.getId(), article.getTitle());
//			}
//
//			System.out.println("==수정 할 내용==");
//			System.out.print("제목 : ");
//			String title = sc.nextLine();
//			System.out.print("내용 : ");
//			String body = sc.nextLine();
//
//			String sqlModify = "UPDATE article ";
//			sqlModify += "SET regDate = NOW(), ";
//			sqlModify += "updateDate = NOW(), ";
//			sqlModify += "title = '" + title + "', ";
//			sqlModify += "`body`= '" + body + "' ";
//			sqlModify += "WHERE id = " + searchId + ";";
//
//			System.out.println(sqlModify);
//
//			pstmt = conn.prepareStatement(sqlModify);
//
//			int affectedRow = pstmt.executeUpdate();
//
//			System.out.println("affectedRow : " + affectedRow);
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 실패");
//		} catch (SQLException e) {
//			System.out.println("에러 : " + e);
//		} finally {
//			try {
//				if (rs != null && !rs.isClosed()) {
//					rs.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (pstmt != null && !pstmt.isClosed()) {
//					pstmt.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (conn != null && !conn.isClosed()) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		if (articles.size() == 0) {
//			System.out.println("게시글이 없습니다");
//			return;
//		}
//
//	}
//
//}
