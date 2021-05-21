<%@page import="com.edu.beans.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/exam01.jsp</title>
</head>
<body>
	<%
		BookBean book = new BookBean();
		book.setAuthor("홍길동");
		book.setPublisher("홍출판사");
		book.setTitle("의적");
		
		request.setAttribute("Hong", book);
	%>
	<c:set var="name" value="123"></c:set>
	<c:out value="${name }"/>
	<p>${name eq 100}</p>
	<c:remove var="name"/>

	<c:set var="title" value="${hong.title }"></c:set>
	<c:out value="${title }"/>
	<p>${Hong}</p>

	<c:set var="author">${Hong.author }</c:set>	
	<c:out value="${author }"/>
	
	<c:set var="pub"><%=book.getPublisher() %> </c:set>
	<c:out value="${pub }"/>
</body>
</html>