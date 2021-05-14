<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example07.jsp::: 스크립트릿(애플릿, 서블릿)</title>
</head>
<body>
	<%!
		// 멤버 변수 선언
		// 메소드 선언
	%>
	<h1>구구단</h1>
	<h3>table 활용해서</h3>
	<TABLE border="1">
	<%
	for (int i = 1; i < 10; i++) {
	%>
	<tr>
	<%
		for (int j = 2; j < 10; j++) {
	%>
		<td><%=j%></td>
		<td>*</td>
		<td><%=i%></td>
		<td>=</td>
		<td><%=i*j%></td>
	<%
		}
	%>
	</tr>
	<%
	}
	%>
	</TABLE>
	
	<hr><h1>교수님 실습</h1>
	<%
	for (int i = 2; i < 10; i++) {
		for (int j = 1; j < 10; j++) {
			out.print(i + "*" + j + "=" + (i * j));
	%>
	<br>
	<%
		}
	}
	%>
</body>
</html>