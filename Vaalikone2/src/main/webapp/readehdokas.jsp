<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One kid read, not fish even they exist</title>
</head>
<body>
<ol>
<c:forEach var="puolue" items="${requestScope.puoluelist }">
<li>${puolue.id}: ${puolue.nimi}
	<ul>
		<c:forEach var="ehdokas" items="${puolue.ehdokaslist}">
			<li>${ehdokas.id }: ${ehdokas.nimi}	
		</c:forEach>
	</ul>	
</c:forEach>
</ol>
</body>
</html>