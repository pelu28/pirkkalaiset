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
            <a href="/new" class="button">Lisää uusi väittämä</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list" class="button">Listaa kaikki väittämät</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${vaittama != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${vaittama == null}">
            <form action="insert" method="post">
        </c:if>
        <table class="styled-table">
            <caption>
                <h2 class="subtitle">
                    <c:if test="${vaittama != null}">
                        Muokkaa Väittämä
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
                    <input type="text" name="otsikko" size="45"
                            value="<c:out value='${vaittama.otsikko}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Väite: </th>
                <td>
                    <input type="text" name="vaite_teksti" size="45"
                            value="<c:out value='${vaittama.vaite}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Luokka: </th>
                <td>
                    <input type="text" name="luokka" size="5"
                            value="<c:out value='${vaittama.luokka}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
            </tbody>
        </table>
        </form>
    </div> 
    </div>
</body>
</html>