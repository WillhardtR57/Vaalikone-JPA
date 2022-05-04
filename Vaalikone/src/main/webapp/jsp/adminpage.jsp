<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <link rel=stylesheet type="text/css" href="/css/styles.css"></link>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vaalikone - Admin Page</title>
</head>
<body>

    <div style="text-align: center">
        <h1>Welcome to Vaalikone Admin Page :-D!!!</h1>
        <b>Hello </b><b>${user.username}</b>
        <br><br>
        <a href="/logout">Logout</a>
    </div>
<p>Authors: Tuukka Kotilainen & Willhardt Räsänen</p>
</body>
</html>