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
            <a href="/answers">Listaa väittämät</a>
             
        </h2>
	
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista vastausvaihtoehdoista</h2></caption>
            <tr>
                <th>Numero</th>
                <th>Vaihtoehdon teksti</th>

            </tr>
            <c:forEach var="vastausvaihtoehdot" items="${listVastausvaihtoehdot}">
                <tr>
                    <td><c:out value="${vastausvaihtoehdot.nro}" /></td>
                    <td><c:out value="${vastausvaihtoehdot.teksti}" /></td>

                </tr>
            </c:forEach>
            
        </table>
    </div>   
</body>
</html>