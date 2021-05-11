package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest")
public class QueryTestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		String id = req.getParameter("id"); // form tag의 name속성에 담겨져있는 값들
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby"); // 한건이 넘어올 수도 있고 여러건이 넘어올 수도 있다(배열 여러건넘어올수있음)
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion"); // select의 name값,multi속성을 이용하면 여러건 선택가능->getParameterValues 로 가져올수있다
		String instroduction = req.getParameter("instroduction");

		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Query 문자열</title></head>");
		out.print("<body><h1>Get 방식 요청</h1>");
		out.print("<h3>아이디 : " + id + "</h3>");
		out.print("<h3>비밀번호 : " + pwd + "</h3>");
		out.print("<h3>이름 : " + name + "</h3>");
		
		for (String hob : hobby) {
			out.print("<h3>취미 : " + hob + "</h3>");
		}
		
		out.print("<h3>종교 : " + religion + "</h3>");
		out.print("<h3>성별 : " + gender + "</h3>");
		out.print("<h3>자기소개 : " + instroduction + "</h3>");
		out.print("<h3>QueryString" + req.getQueryString() + "</h3>");
		out.print("</body></html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Query 문자열</title></head>");
		out.print("<body><h1>Post 방식 요청</h1>");
		
		ServletInputStream input = req.getInputStream();
		int len = req.getContentLength();
		byte[] buf = new byte[len];
		input.readLine(buf, 0, len);
		String str = new String(buf);
		System.out.println("str : " +len+","+str);
		
		out.print("<h3>QueryString : " + str + "</h3>");
		out.print("</body></html>");
		out.close();

	}

}
