<%@page import="com.edu.test.stateless.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example17.jsp</title>
</head>
<body>
<%
	String id = request.getParameter("memberId");
	String pw = request.getParameter("memberPwd");
	String nm = request.getParameter("memberName");
	String ag = request.getParameter("memberAge");
	
	Member member1 = new Member();

	member1.setMemberId(id);
	member1.setMemberName(nm);
	member1.setMemberAge(Integer.parseInt(ag));
	member1.setMemberPwd(pw);
	
	out.print(member1.getMemberId()+"<br>");
	out.print(member1.getMemberName()+"<br>");
	out.print(member1.getMemberAge()+"<br>");
	out.print(member1.getMemberPwd()+"<br>");
%>

<jsp:useBean id="member2" class="com.edu.test.stateless.Member"></jsp:useBean>
<jsp:setProperty property="*" name="member2"/>
<!-- 필드값 전체 받아올떄 VO와 필드이름 name 를 맞춰줘야 값을 가져 올 수 있다  -->

<%-- 
<jsp:setProperty property="memberId" name="member2" value="10"/>
<jsp:setProperty property="memberPwd" name="member2" value="1234"/>
<jsp:setProperty property="memberName" name="member2" value="Hong"/>
<jsp:setProperty property="memberAge" name="member2" value="20"/>
--%>

<jsp:getProperty property="memberId" name="member2"/>
<jsp:getProperty property="memberName" name="member2"/>
<jsp:getProperty property="memberAge" name="member2"/>
<jsp:getProperty property="memberPwd" name="member2"/>


</body>
</html>