package com.edu.test.stateless;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context2")
public class ServletContextText2Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ServletContext -> 값을 지정.obj1, obj2
		
		ServletContext sc = this.getServletContext(); // servletContext2 = this
		
		ShareObject so1 = new ShareObject();
		so1.setCount(100);
		so1.setStr("객체공유테스트 - 1");
		sc.setAttribute("data1",so1); 
		
		ShareObject so2 = new ShareObject();
		so1.setCount(200);
		so1.setStr("객체공유테스트 - 2");
		sc.setAttribute("data2",so2); 
		
		
	}
}
