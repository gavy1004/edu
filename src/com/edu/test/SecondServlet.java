package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/secondServlet" })
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SecondServlet() {
        super();
    }
    // init() -> request, response -> service(request, response)

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");	// 사용자가 요청한 name 값을 name 변수에 담아주었다
		String age = request.getParameter("age"); 
		System.out.println("name : "+ name);
		System.out.println("age : "+ age);
		
//		Enumeration<String> en = request.getHeaderNames(); // header의 요청정보 
//		while(en.hasMoreElements()) {
//			String key = en.nextElement();
//			String val = request.getHeader(key);
//			System.out.println(key+","+val);
//		}
//		
//		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		response.sendRedirect("index.html");
		PrintWriter out =  response.getWriter();
//		response.setHeader("name","Hong");
		out.print("<h1>"+name+"</h1>");
		out.print("<h1>"+age+"</h1>");
//		
//		ArrayList<String> col = (ArrayList<String>) response.getHeaderNames();
//		for(String key : col) {
//			String val = response.getHeader(key);
//			System.out.println(key +","+ val);
//		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
