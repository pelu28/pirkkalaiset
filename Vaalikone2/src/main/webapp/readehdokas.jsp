<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="dao.ListEhdokkaatDao" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>One kid read, not fish even they exist</title>
</head>
<body>
  <div class="background" align="center">
        <h1>Vaalikone Hallinta</h1>
    <div align="center">
        <table class="styled-table">
            <caption><h2 class="subtitle">Väittämät</h2></caption>
            <thead>
	            <tr>
	                <th>ID</th>
	                <th>Otsikko</th>
	                <th>Vaite</th>
	                <th>Luokka</th>
	                <th>Actions</th>
	                <th>Luokka</th>
	                <th>Actions</th>
	                <th>Luokka</th>
	                <th>Actions</th>
	            </tr>
            </thead>
            <tbody>
            	<!-- Tulostetaan taulukon jokaiselle riville väittämän tiedot kannasta ja seuraavalle riville vastausvaihtoehdot kannasta -->
            	<c:forEach var="ehdokkaat" items="${listEhdokkaat}" varStatus="loop">
	                <tr>
	                    <td><c:out value="${id}" /></td>
	                    <td><c:out value="${ehdokasNro}" /></td>
	                    <td><c:out value="${ehdokkaat.puolue}" /></td>
	                    <td><c:out value="${ehdokkaat.etunimi}" /></td>
	                    <td><c:out value="${ehdokkaat.sukunimi}" /></td>
	                    <td><c:out value="${ehdokkaat.postinumero}" /></td>
	                    <td><c:out value="${ehdokkaat.postitoimipaikka}" /></td>
	                    <td><c:out value="${ehdokkaat.lahiosoite}" /></td>
	                    <td><c:out value="${ehdokkaat.miksi}" /></td>
	                   
	                </tr>
					
					
            	</c:forEach>
            </tbody>
        </table>
</body>
</html>