package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet { // 세션 활용 방법
	// 로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		if (id.isEmpty() || pwd.isEmpty()) {
			out.print("ID 또는 비번을 입력하세요");
			return; // 더이상 작업을 실행하지 않고 메소드를 종료 하겠다
		}

		HttpSession session = req.getSession();
		if (session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id);
			session.setAttribute("data1", "100");	//세션이 연결되어있는 동안은 이값을 읽어 올 수 있다.. 
			out.print("로그인 완료");
		} else {
			out.print("이미 로그인 상태입니다");
		}
		out.close();
	}

	// 로그아웃 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false); // null인지 아닌지 확인하려고
		if (session != null && session.getAttribute("id") != null) {
			session.invalidate();
			out.print("로그아웃 완료");
		} else {
			out.print("로그인 상태가 아닙니다");
		}
		out.close();
	}

}
