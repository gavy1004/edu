<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example10.jsp</title>
</head>
<body>

	<%
		// request 자동으로 만들어지는 내장객체 
		String rid = null;
		String name = null;
		int age=0;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		if(id == null){
			id=(String)session.getAttribute("id");
		}
		if(pwd == null) {
			pwd=(String)session.getAttribute("pwd");
		}
		if(id.isEmpty() || pwd.isEmpty()) {
			// 아이디나 비밀번호 값을 넣지않으면 다시 로그인 페이지로 돌아간다
			request.setAttribute("err", "ID,비밀번호 입력하세요");
			RequestDispatcher rd = request.getRequestDispatcher("logInOut.jsp");
			rd.forward(request, response);
			return;
		}
		// 로그인 처리 
		if (session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id);
			session.setAttribute("pwd",pwd);
			session.setAttribute("name", "심코코");
			session.setAttribute("age", 8);
			out.print("로그인 작업이 완료");
		} else {
			out.print("이미 로그인 상태 입니다");
			rid = (String) session.getAttribute("id");
			name= (String) session.getAttribute("name");
			age= (int) session.getAttribute("age");
		}
	%>
	
	<!-- 단순 표현식 표현하는 선언식  -->
	<h3>아이디 : <%=id %></h3>
	<h3>비밀번호 : <%=pwd %></h3>
</body>
</html>