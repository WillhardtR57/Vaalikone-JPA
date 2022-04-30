<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.*" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <link rel=stylesheet type="text/css" href="/css/styles.css"></link>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone - Edit Candidate</title>
</head>
<body>
<c:import url="../navbaradmin.html" charEncoding="UTF-8"/>

<h1>Editing candidate</h1>

<br>

<form action='/rest/candidatesrest/editcandidates' method='post' accept-charset="UTF-8">

<b>Candidate number</b>
<input type="text" name='ehdokas_id' value='${requestScope.candidate.ehdokas_id}'> <br>

<b>Last name</b> <br>
<input type="text" name='sukunimi' value='${requestScope.candidate.sukunimi}'> <br>

<b>First name</b> <br>
<input type="text" name='etunimi' value='${requestScope.candidate.etunimi}'> <br>

<b>Party</b> <br>
<input type="text" name='puolue' value='${requestScope.candidate.puolue}'> <br>

<b>Home</b> <br>
<input type="text" name='kotipaikkakunta' value='${requestScope.candidate.kotipaikkakunta}'> <br>

<b>Age</b> <br>
<input type="text" name='ika' value='${requestScope.candidate.ika}'> <br>

<b>Why do you want to enter parliament?</b><br>
<textarea rows="5" cols="80" name='miksi_eduskuntaan' style="width:24rem;">${requestScope.candidate.miksi_eduskuntaan}</textarea><br>

<b>What things you want to represent?</b> <br>
<textarea rows="5" cols="80" name='mita_asioita_haluat_edistaa' style="width:24rem;">${requestScope.candidate.mita_asioita_haluat_edistaa}</textarea><br>

<b>Profession</b> <br>
<input type="text" name='ammatti' value='${requestScope.candidate.ammatti}'> <br> 

<input type='Submit' name='ok' value='Save'> 
</form>

<p>Authors: Tuukka Kotilainen & Willhardt Räsänen</p>
</body>
</html>