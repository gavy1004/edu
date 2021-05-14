<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
JSP프로그래밍

<%
	Date date = new Date();
%>
<%
	java.util.List<String> list = new java.util.ArrayList<>();
	out.print(date);
%>
