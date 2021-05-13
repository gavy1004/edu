package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieTestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		// 쿠키 key value
		Cookie c1 = new Cookie("id", "guest");
		c1.setPath("/"); // 서버의 특정위치 /edu 애플리케이션의 전체 위치에서 활용
		resp.addCookie(c1); // 클라이언트 쪽으로 전송

		Cookie c2 = new Cookie("code", "0001");
		c2.setMaxAge(3 * 60 * 60); // 해당기간 동안만 쿠키 유효하게 설정
		c2.setPath("/");
		resp.addCookie(c2);

		Cookie c3 = new Cookie("subjest", "java");
		c3.setMaxAge(10 * 24 * 60 * 60); // 쿠키가 유효한 기간 10일 (5.22일까지 유효)
		c3.setPath("/");
		resp.addCookie(c3);
		
		out.print("쿠키 전송 완료");
		out.close();
	}
}
