package com.edu.test.stateless;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberRegister")
public class PutMemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// db에서 리스트 -> memberList.jsp
		resp.setContentType("text/html;charset=UTF-8");

		MemberDAO dao = new MemberDAO();
		List<Member> list = dao.getMemberList();
		for(Member mem : list ) {
			System.out.println(mem.getMemberName());
		}

		RequestDispatcher rd = req.getRequestDispatcher("memberList.jsp");
		req.setAttribute("memberList", list);
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// parameter 를 읽어서 db insert, -> 결과를 memberResult.jsp로 이동
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String age = req.getParameter("age");

		MemberDAO dao = new MemberDAO();
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPwd(pwd);
		member.setMemberName(name);
		member.setMemberAge(Integer.parseInt(age)); // int type 변환
		dao.insertMember(member);

		// this.getServletContext();//ServletContext RD객체
		RequestDispatcher rd = req.getRequestDispatcher("memberResult.jsp");
		req.setAttribute("member", member);
		rd.forward(req, resp);

	}
}
