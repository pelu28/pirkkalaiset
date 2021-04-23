<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Vaalikone Sivusto</title>
    <link rel="stylesheet" type="text/css" href="styles.css"/>
</head>
<body>
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
							<c:forEach var="table" items="${listVastausvaihtoehdot}">  
							<tr>  
							<td><c:out value="${table.teksti}"/></td>  
							</tr>  
							</c:forEach>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div> 
</body>
</html>