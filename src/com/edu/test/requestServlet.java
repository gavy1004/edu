package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requestServlet")
public class requestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public requestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
	
		String name = request.getParameter("name");
		String id = request.getParameter("user_id");
		String age = request.getParameter("user_age");
		
		PrintWriter out =  response.getWriter();
		out.print("<table border='1'>");
		out.print("<tr><th>이름</th><td>"+name+"</td></tr>");
		out.print("<tr><th>아이디</th><td>"+id+"</td><</tr>");
		out.print("<tr><th>나이</th><td>"+age+"</td><</tr></table>");
	
	}
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html;charset=UTF-8");
//		
//		String met =  req.getMethod();
//		System.out.println(met);
//		
//		String name =req.getParameter("name");
//		String id =req.getParameter("user_id");
//		String age = req.getParameter("user_age");
//		
//		PrintWriter out = resp.getWriter();
//		
//		if(met.equals("GET")) {
//			out.print("<table border='1'>");
//			out.print("<tr><th>이름1</th><td>"+name+"</td></tr>");
//			out.print("<tr><th>아이디1</th><td>"+id+"</td><</tr>");
//			out.print("<tr><th>나이1</th><td>"+age+"</td><</tr>");
//			out.print("</table>");
//		}else{
//			out.print("<ul><li>");
//			out.print(name+"</li><li>");
//			out.print(id+"</li><li>");
//			out.print(age+"</li>");
//			out.print("</ul>");
//		}
//	
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String name =  request.getParameter("name");
		String id =  request.getParameter("user_id");
		String age =  request.getParameter("user_age");
		
		PrintWriter out = response.getWriter();
		
		out.print("<table border='1'>");
		out.print("<tr><th>이름post</th><td>"+name+"</td></tr>");
		out.print("<tr><th>아이디post</th><td>"+id+"</td><</tr>");
		out.print("<tr><th>나이post</th><td>"+age+"</td><</tr></table>");
	
		
		
		
	}

}
