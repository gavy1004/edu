package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher1")
public class DispatcherTest1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String param = req.getParameter("p");
		if (param == null || param.isEmpty()) {
			param = "Null"; // param 값을 setattrebute 로 넘김
		}

		out.print("<h3>Dispatcher 수행 1</h3>");

		ServletContext sc = this.getServletContext(); // edu관리
		RequestDispatcher rd = sc.getRequestDispatcher("/dispatcher2"); // dispatcher 메소드 넘겨줄
		req.setAttribute("data1", "good");
		req.setAttribute("data2", param);
		rd.forward(req, resp);
		out.close();

	}
}
