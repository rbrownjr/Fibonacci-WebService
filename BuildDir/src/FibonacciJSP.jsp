<!--
*  This file represents the Fibonacci JSP.
*  It is used to display a Fibonacci Sequnce in HTML.
*  The Fibonacci sequnce is frowarded to this JSP from the Fibonacci
*  Servlet.
* 
* @author Robert Brown
* @version 1.0
* 
* -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Fibonacci App</h1>
<p>The result is: <%= request.getAttribute("data") %>
</body>
</html>