package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookReg")
public class BookTestSerlver extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String pulisher = req.getParameter("pulisher");
		
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPulisher(pulisher);
		
		req.setAttribute("book", book);
		
		RequestDispatcher rd = req.getRequestDispatcher("bookOutput");
		rd.forward(req, resp);
		
		out.close();
		
	}
	
}
