<%@page import="com.edu.test.stateless.Member"%>
<%@page import="com.edu.test.stateless.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="logInOut.jsp">로그아웃</a>
	<%
	%>


	<%
	// String 객체 ==> equals

		MemberDAO dao = new MemberDAO();
		Member mem = new Member();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		mem = dao.checkInfo(id, pwd);
		String name = mem.getMemberName();
		int age = mem.getMemberAge();
	if (request.getMethod().equals("POST")) {

		if (mem == null||mem.getMemberId() == null) {
			out.print("<h3>사용자 정보없음</h3>");
		} else {
			session.setAttribute("info", mem);
			out.print("<h3>이름 :" + mem.getMemberName()+"</h3>");
			
		}
	} else { //get -> 로그아웃
		session.invalidate();
		out.print("로그아웃 됨");
	}
	%>
</body>
</html>