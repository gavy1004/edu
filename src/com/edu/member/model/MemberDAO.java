package com.edu.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	
	private void connect() {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds =  (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (NamingException  | SQLException e) {
			e.printStackTrace();
		}
		
	}
	// 파일, 디비에 저장하는 기능 구현
	
	
	public void insertMember(MemberVO member) {
		connect();
		String sql = "insert into member_b (id,passwd,name,mail) values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPasswd());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getMail());
			
			int r =psmt.executeUpdate();
			System.out.println(r+"건이 입력되었습니다");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
