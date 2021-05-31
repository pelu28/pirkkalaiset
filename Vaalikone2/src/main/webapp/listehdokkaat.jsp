<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ehdokkaat</title>

</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // private sivu, ei tallenna keksejä, joten back nappi ei vie edelliseen sessio sivulle
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
    
	if(session.getAttribute("user")==null) // ookkona kirjautuneena
		response.sendRedirect("Login.jsp"); // jos ei ole, niin takaisin login sivulle ohjaus
%>
    <div class="background" align="center">
        <h1>Ehdokkaat</h1>
    <div align="center">
        <table class="styled-table">
            <caption><h2 class="subtitle">Väittämät</h2></caption>
            <thead>
	            <tr>
	               
	                <th>Ehdokasnro</th>
	                <th>puolue</th>
	                <th>etunimi</th>
	                <th>sukunimi</th>
	                <th>postinumero</th>
	                <th>postitoimipaikka</th>
	                 <th>Lähiosoite</th>
	                  <th>Miksi</th>
	                
	            </tr>
            </thead>
            <tbody>
            	<!-- Tulostetaan taulukon jokaiselle riville väittämän tiedot kannasta ja seuraavalle riville vastausvaihtoehdot kannasta -->
            	<form action="./ReadEhdokkaat">
            	<input type="submit" value="Submit">
	                          </tbody>
               </table>
               </div>
               </body>
               </html>
               
        
	            