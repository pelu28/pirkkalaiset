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
    
    	<!-- Tutkitaan onko päivitys vai uuden lisäys -->
        <c:if test="${vaittama != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${vaittama == null}">
            <form action="insert" method="post">
        </c:if>
        
        <table class="styled-table" id="narrow">
            <caption>
                <h2 class="subtitle">
                    <c:if test="${vaittama != null}">
                        Muokkaa väittämää
                    </c:if>
                    <c:if test="${vaittama == null}">
                        Lisää uusi väittämä
                    </c:if>
                </h2>
            </caption>
            <thead>
            	<tr>
            		<th colspan="2"> </th>
            	</tr>
            </thead>
            <tbody>
                <c:if test="${vaittama != null}">
                    <input type="hidden" name="id" value="<c:out value='${vaittama.id}' />" />
                </c:if>
                      
            <tr>
                <th>Otsikko: </th>
                <td>
                    <input type="text" name="otsikko" size="20"
                            value="<c:out value='${vaittama.otsikko}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Väite: </th>
                <td>
                    <input type="text" name="vaite_teksti" size="60"
                            value="<c:out value='${vaittama.vaite}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Luokka: </th>
                <td>
                    <input type="text" name="luokka" size="10"
                            value="<c:out value='${vaittama.luokka}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" class="save" value="Tallenna" />
                </td>
            </tr>
            </tbody>
        </table>
        </form>
        <h2>
            <a href="/list" class="button">Peruuta</a> 
        </h2>
    </div> 
    </div>
</body>
</html>