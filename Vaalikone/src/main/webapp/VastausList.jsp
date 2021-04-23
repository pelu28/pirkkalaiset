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
            <a href="/answers" class="button">Listaa väittämät</a>
             
        </h2>
    <div align="center">
        <table class="styled-table">
            <caption><h2 class="subtitle">Lista vastausvaihtoehdoista</h2></caption>
            <thead>
            <tr>
                <th>Numero</th>
                <th>Vaihtoehdon teksti</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="vastausvaihtoehdot" items="${listVastausvaihtoehdot}">
                <tr>
                    <td><c:out value="${vastausvaihtoehdot.nro}" /></td>
                    <td><c:out value="${vastausvaihtoehdot.teksti}" /></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>  
</body>
</html>