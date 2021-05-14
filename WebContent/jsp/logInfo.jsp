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

<%
	//db 조푀 후 가져온 Member 확인 후 이름 나이 출력 해당하지 않으면 해당사용자 없음
	String id = request.getParameter("id");	
	String pwd = request.getParameter("pwd");
	
	MemberDAO dao = new MemberDAO();
	Member mem = dao.checkInfo(id,pwd);
	
	String name = mem.getMemberName();
	int age = mem.getMemberAge();
%>
	<h3>아이디 : <%=id %></h3>
	<h3>비밀번호 : <%=pwd %></h3>
	<h3>이름 : <%=name %></h3>
	<h3>나이 : <%=age %></h3>


</body>
</html>