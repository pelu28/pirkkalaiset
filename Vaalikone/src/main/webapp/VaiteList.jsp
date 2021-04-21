<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Vaalikone Sivusto</title>
    <link rel="stylesheet" type="text/css" href="styles.css"/>
</head>
<body>
    <center>
        <h1>Vaalikone Hallinta</h1>
        <h2>
            <a href="/new">Lisää väittämä</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">Listaa väittämät</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista väitteistä</h2></caption>
            <tr>
                <th>ID</th>
                <th>Otsikko</th>
                <th>Vaite</th>
                <th>Luokka</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="vaittama" items="${listVaittamat}">
                <tr>
                    <td><c:out value="${vaittama.id}" /></td>
                    <td><c:out value="${vaittama.otsikko}" /></td>
                    <td><c:out value="${vaittama.vaite}" /></td>
                    <td><c:out value="${vaittama.luokka}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${vaittama.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${vaittama.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
            
        </table>
    </div>   
</body>
</html>