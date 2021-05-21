package com.edu.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

// 전체리스트, 신규 입력, 수정, 삭제 -DBMS
	// 한건 조회
	public BookBean getBook(String title) {
		String sql = "select * from book where title = ? ";
		conn = DAO.connet();
		BookBean book = new BookBean();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			rs = psmt.executeQuery(); // 여러 조건 결과룰 rs에 담음
			if (rs.next()) { // 한건 조회 시에 if문사용
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return book;
	}

	// 전체 리스트 조회 
	public List<BookBean> getBookList() {
		String sql = "select * from book ";
		conn = DAO.connet();
		List<BookBean> bookList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BookBean book = new BookBean();
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}

		return bookList;
	}
	
	// 저자별 책 조회 :author -> 책 리스트를 반환(getBooksByAhuthoy)
	public List<BookBean> getBooksByAhuthoy(String author) {
		String sql = "select * from book where author = ? ";
		conn = DAO.connet();
		List<BookBean> bookList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, author);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BookBean book = new BookBean();
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return bookList;
	}
	
	public void insertBook(BookBean book) {
		String sql = "insert into book values(?,?,?)";
		conn = DAO.connet();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,book.getTitle());
			psmt.setString(2,book.getAuthor());
			psmt.setString(3,book.getPublisher());
			int r =psmt.executeUpdate();
			System.out.println(r+"건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	public void deleteBook(String title) {
		
	}

}
