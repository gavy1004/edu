<%@page import="java.util.List"%>
<%@page import="com.edu.test.stateless.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList.jsp</title>
<style>
table tr {
	border: 1px solid black;
}
</style>
</head>
<body>
		<ul>
		<%
		List<Member> list = (List<Member>) request.getAttribute("memberList");
	
		
		for (Member mem : list) {
			out.print("<table><tr><td>" + mem.getMemberName() + "</td><td>"+ mem.getMemberId()+"</td></tr></table>");
		}
		%>
		</ul>

</body>
</html>