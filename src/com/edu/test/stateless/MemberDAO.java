package com.edu.test.stateless;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {
	Connection conn;
	PreparedStatement psmt = null;
	ResultSet rs;

	public MemberDAO() {
		DataSource ds = DataSource.getIncetance();
		conn = ds.getConnection();
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
			while(rs.next()) {
				mem.setMemberName(rs.getString("Member_name"));
				mem.setMemberAge(rs.getInt("member_age"));
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
		return mem;

	}

}
