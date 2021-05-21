package com.edu.member.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.member.model.MemberService;
import com.edu.member.model.MemberVO;

@WebServlet("/member/memberProc.do")
public class MemberControl extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 사용자의 입력 -> 요청처리 (Oracle 저장) -> 처리결과(memberOutput.jsp)
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		
		// 받아온 값을 넣어 준다 
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMail(mail);
		
		// 서비스 로직(MemberService.java)
		// DB 처리 (MemberDAO.java)
		MemberService service = new MemberService();
		service.memberInsert(member);
		
		request.setAttribute("member",member);
		// 처리결과 (MemberOutput.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("memberOutput.jsp");
		rd.forward(request, response);
		
		
	}
}
