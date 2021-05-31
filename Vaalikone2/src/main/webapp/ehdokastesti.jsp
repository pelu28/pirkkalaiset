<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>    
<%@ page import="data.*" %>
<%@ page import="app.EhdokkaatClient" %>
<%@ page import="rest.EhdokkaatServicce" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>Ehdokkaiden poisto</title>
</head>
<body>
<h2>Poista ehdokas</h2>
<br>
	<c:forEach var="ehdokkaat" items="${requestScope.Ehdokkaatlist}">
		<b>Id</b>
		${ehdokkaat.id}<br>
		<b>Puolue</b><br>
		${ehdokkaat.puolue}<br>
		<a id="deleteehdokas" href="ehdokkaatclient?deleteId=${ehdokkaat.id}">Poista puolue</a><br>
		</c:forEach>
</body>
</html>