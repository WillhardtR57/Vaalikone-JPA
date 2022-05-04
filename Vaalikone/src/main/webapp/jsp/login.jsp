<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 
<c:import url="../navbar.html" charEncoding="UTF-8"/>
<link rel="stylesheet" href="../styles.css">

<h2>Log In!</h2>

<form action="/rest/loginrest/login" method="POST">
<label>Username:</label> <br>
<input type="text" placeholder="Input username" name="username"> <br>
<label>Password:</label> <br>
<input type="password" placeholder="Input password" name="password"> <br>
<button type="submit">Submit</button>
</form>
<%
String userProvidedUsername = (String)request.getAttribute("userProvidedUsername");
String username = (String)request.getAttribute("username");
String password = (String)request.getAttribute("password");
String MD5Password = (String)request.getAttribute("MD5Password");
%>
<%
if(data.LoginData.CheckPasswords(MD5Password, password)==true && userProvidedUsername.equals(username)){
	response.sendRedirect("/jsp/adminpage.jsp");
} else if (data.LoginData.CheckPasswords(MD5Password, password)==false || userProvidedUsername!=username){
%>
<div id="loginFailure">Username or password is incorrect!</div>
<%
}
%>
<%@include file="../footer.html" %>
