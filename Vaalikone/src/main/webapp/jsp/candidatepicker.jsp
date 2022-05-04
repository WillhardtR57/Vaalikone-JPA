<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.*" %> 
 <%@ page import="dao.Dao" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<link rel=stylesheet type="text/css" href="/css/styles.css"></link>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Vaalikone - Edit Candidates</title>
</head>
<body>
<c:import url="../navbar.html" charEncoding="UTF-8"/>
<h1>You can edit or delete candidates</h1>

<c:forEach var="candidate" items="${requestScope.candidateslist}" >

${candidate.etunimi}, ${candidate.sukunimi} 
<a href="/rest/candidatesrest/getcandidateid/${candidate.ehdokas_id}">Edit</a> 
<a href="/rest/candidatesrest/deletecandidate/${candidate.ehdokas_id}">Delete</a> <br><br>

</c:forEach>

<p>Authors: Tuukka Kotilainen & Willhardt Räsänen</p>
</body>
</html>