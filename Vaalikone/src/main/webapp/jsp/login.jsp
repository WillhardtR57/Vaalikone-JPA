<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 
<c:import url="../navbar.html" charEncoding="UTF-8"/>
<link rel="stylesheet" href="../styles.css">

<h2>Log IN! XD</h2>

<form action="/rest/loginrest" method="POST">
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
%>
<%
if(data.LoginData.CheckPasswords(username, password)==true && userProvidedUsername.equals(username)){
	response.sendRedirect("/jsp/adminpage.jsp");
} else if(password==null || userProvidedUsername==null){
	
%>
<div id="loginFailure">Username or password is incorrect! XD</div>
<%
}
%>
<%@include file="../footer.html" %>
