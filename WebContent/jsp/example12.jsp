<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example12.jsp</title>
</head>
<body>
<h1>example12/jsp</h1>
<%-- <% inClude file="example05.jsp" %> --%>
<%!
	public void work (String p, PageContext pc) {
		try{
		JspWriter out = pc.getOut();
		
			if(p.equals("inClude")) {
				out.print("inClude 전");
				pc.include("example05.jsp");
				out.print("inClude 후");
			} else if (p.equals("forward")) {
				pc.forward("example05.jsp");
			}
		} catch (Exception e) {
			System.out.print("오류발생");
		}
	}%>
	
	<%
		String p =request.getParameter("p");
		this.work(p, pageContext);	
	%>

</body>
</html>