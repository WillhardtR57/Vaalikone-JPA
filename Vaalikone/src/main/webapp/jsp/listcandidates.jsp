<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<title>Vaalikone - All Candidates</title>
</head>
<body>



<c:forEach var="candidate" items="${sessionScope.candidateslist}" >
<p><b>${candidate.ehdokas_id}:</b> ${candidate.etunimi} ${candidate.sukunimi} </p>
<b>Party: </b><br>
${candidate.puolue} <br>
<b>Home:</b><br>
${candidate.kotipaikkakunta}<br>
<b>Age: </b><br>
${candidate.ika}<br>
<b>Profession:</b><br>
${candidate.ammatti}<br>
<b>Why do you want to enter parliament?</b><br>
${candidate.miksi_eduskuntaan}<br>
<b>What things you want to represent?</b><br>
${candidate.mita_asioita_haluat_edistaa}<br>
<br> <br>

</c:forEach>

</body>
</html>