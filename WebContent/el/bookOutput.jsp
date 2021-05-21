<%@page import="com.edu.beans.BookBean"%>
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
	BookBean book = (BookBean) request.getAttribute("book");
%>
<h1>정상적으로 처리 되었습니다</h1>
<h3>책제목 : ${book.title }</h3><p><%=book.getTitle() %></p>
<h3>책저자 : ${book.author }</h3><p><%=book.getAuthor() %></p>
<h3>출판사 : ${book.publisher }</h3><p><%=book.getPublisher() %></p>

</body>
</html>