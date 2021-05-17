package com.edu.test.stateless;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MemberDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public MemberDAO() {
		//DataSource ds = DataSource.getIncetance();
		//conn = ds.getConnection();
		//Connection Pool을 활용해서 Connection 객체
		try {
			InitialContext ic = new InitialContext();	// 서버의 리소스관리 하는 객체
			javax.sql.DataSource ds = (DataSource) ic.lookup("jdbc:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
			
		} catch (NamingException | SQLException e) {	//Exception e
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void close() {
		try {
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Member> getMemberList() {
		String sql = "select * from member order by 1";
		List<Member> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Member mem = new Member();
				mem.setMemberAge(rs.getInt("member_age"));
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberPwd(rs.getString("member_pwd"));
				list.add(mem);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void insertMember(Member mem) {
		String sql = "insert into member(member_id, member_name, member_age, member_pwd) values(?,?,?,?)";
		try {

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, mem.getMemberId());
			psmt.setString(2, mem.getMemberName());
			psmt.setInt(3, mem.getMemberAge());
			psmt.setString(4, mem.getMemberPwd());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public Member checkInfo(String id, String pwd) {
		// id, pwd 조회 값이 있으면 조회 -> Member에 리턴 return memger;
		String sql = "select * from member where MEMBER_ID=? and member_pwd=?";
		Member mem = new Member();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			while (rs.next()) {
				mem.setMemberName(rs.getString("Member_name"));
				mem.setMemberAge(rs.getInt("member_age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return mem;
	}

	// 한건 조회
	public Member getMember(String id) {
		String sql = "select * from member where MEMBER_ID=? ";
		Member mem = new Member();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				mem.setMemberName(rs.getString("Member_name"));
				mem.setMemberId(rs.getString("Member_Id"));
				mem.setMemberPwd(rs.getString("Member_Pwd"));
				mem.setMemberAge(rs.getInt("member_age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return mem;

	}

}
