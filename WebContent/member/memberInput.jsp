<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록 (memberInput.jsp)</title>
<!-- 
사용자 입력하는 화면 
package com.edu.member.model
package com.edu.member.control
 -->
</head>
<body>
<form action="memberProc.do" method="post">
	ID: <input type="text" name ="id"><br>
	PW: <input type="password" name="passwd"><br>
	Name: <input type="text" name="name"><br>
	Mail: <input type="email" name="mail"><br>
	<input type="submit" value="등록">
</form>
<!-- 
MVC 
Model : 클래스, 서비스 (Sevice), 디비처리 (DAO)
View : 사용자에게 화면 (jsp)
Controller: jsp (MVC1) , servlet (MVC2)


memberInput.jsp (입력화면)
-> memverProc.jsp (사용자입력 처리)
-> MemverService.java(서비스로직)
-> MemberDAO.java
-> OracleDBMS.jsp (출력화면)

 -->


</body>
</html>