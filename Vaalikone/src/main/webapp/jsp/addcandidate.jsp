<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.*" %> 
 <%@ page import="dao.Dao" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<link rel=stylesheet type="text/css" href="/css/styles.css"></link>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaalikone - Add candidate</title>
</head>
<body>
<c:import url="../navbaradmin.html" charEncoding="UTF-8"/>

<h1>Add candidate</h1>

<form method='post' action='/rest/candidatesrest/addcandidate' accept-charset="UTF-8">

<b>Last name</b> <br>
<input type="text" name='sukunimi' value=''> <br>

<b>First name</b> <br>
<input type="text" name='etunimi' value=''> <br>

<b>Party</b> <br>
<input type="text" name='puolue' value=''> <br>

<b>Home</b> <br>
<input type="text" name='kotipaikkakunta' value=''> <br>

<b>Age</b> <br>
<input type="text" name='ika' value=''> <br>

<b>Why do you want to enter parliament?</b><br>
<textarea rows="5" cols="80" name='miksi_eduskuntaan' style="width:24rem;"></textarea><br>

<b>What things you want to represent?</b> <br>
<textarea rows="5" cols="80" name='mita_asioita_haluat_edistaa' style="width:24rem;"></textarea><br>

<b>Profession</b> <br>
<input type="text" name='ammatti' value=''> <br> 

<input type='Submit' name='ok' value='Add'> 
</form>

<p>Authors: Tuukka Kotilainen & Willhardt Räsänen</p>
</body>
</html>