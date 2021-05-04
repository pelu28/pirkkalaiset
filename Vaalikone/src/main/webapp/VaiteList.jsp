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

	if(session.getAttribute("user")==null) // ookkona kirjautuneena
		response.sendRedirect("Login.jsp"); // jos ei ole, niin takaisin login sivulle ohjaus
%>
    <div class="background" align="center">
        <h1>Vaalikone Hallinta</h1>
        <h2>
            <button class="button"><a href="/new">Lisää väittämä</a>
            &nbsp;&nbsp;&nbsp;</button>
            <button class="button"><a href="/list">Listaa väittämät</a></button>
        </h2>
    <div align="center">
        <table class="styled-table">
            <caption><h2 class="subtitle">Lista väitteistä</h2></caption>
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
            <c:forEach var="vaittama" items="${listVaittamat}">
            	
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
				
					<td><input type="radio"><c:out value="${vastaus.teksti}"/></td>
				 
				</c:forEach>
				</tr>
				
							
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="topright">
    	<a href="/logout">Kirjaudu ulos</a>
    </div>
    
</div>

</body>
</html>