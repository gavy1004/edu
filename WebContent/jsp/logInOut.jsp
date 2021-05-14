<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logInOut.jsp</title>
</head>
<body>
	<%
		String msg =(String) request.getAttribute("err");
		if(msg == null) {
			msg = " ";
		}
	%>
	<%=msg %>
	<form action='logInfo.jsp' method="post">
		ID : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pwd"><br>		
		<input type="submit" value="로그인">
	</form>
</body>
</html>