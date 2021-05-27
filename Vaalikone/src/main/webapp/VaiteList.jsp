<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Vaalikone Sivusto</title>
    <link rel="stylesheet" type="text/css" href="styles.css"/>
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
	            </tr>
            </thead>
            <tbody>
            	<!-- Tulostetaan taulukon jokaiselle riville väittämän tiedot kannasta ja seuraavalle riville vastausvaihtoehdot kannasta -->
            	<c:forEach var="vaittama" items="${listVaittamat}" varStatus="loop">
	                <tr>
	                    <td><c:out value="${vaittama.id}" /></td>
	                    <td><c:out value="${vaittama.otsikko}" /></td>
	                    <td><c:out value="${vaittama.vaite}" /></td>
	                    <td><c:out value="${vaittama.luokka}" /></td>
	                    <td>
	                        <a href="/edit?id=<c:out value='${vaittama.id}' />" class="action">Edit</a>
	                        &nbsp;&nbsp;&nbsp;&nbsp;
	                        <a href="/delete?id=<c:out value='${vaittama.id}' />" class="action">Delete</a>                     
	                    </td>
	                </tr>
					
					<tr>
					<c:forEach var="vastaus" items="${listVastausvaihtoehdot}">
						<!-- loop.index-kikalla saadaan radiobuttonit omiksi ryhmikseen, eli vain yksi voidaan valita joka riviltä -->
						<td><input type="radio" name="vastaus${loop.index+1}"><c:out value="${vastaus.teksti}"/></td>
					</c:forEach>
					</tr>
            	</c:forEach>
            </tbody>
        </table>
        <h2>
            <button class="button"><a href="/new">Lisää väittämä</a></button>
        </h2>
    </div>
    <div class="topright">
    	<a href="/logout">Kirjaudu ulos</a>
    </div>
    
</div>

</body>
</html>