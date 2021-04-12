<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Vaalikone Sivusto</title>
</head>
<body>
    <center>
        <h1>Vaalikone Hallinta</h1>
        <h2>
            <a href="/new">Add New Book</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Books</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${vaittama != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${vaittama == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${vaittama != null}">
                        Edit Book
                    </c:if>
                    <c:if test="${vaittama == null}">
                        Add New Book
                    </c:if>
                </h2>
            </caption>
                <c:if test="${vaittama != null}">
                    <input type="hidden" name="id" value="<c:out value='${vaittama.id}' />" />
                </c:if>           
            <tr>
                <th>Title: </th>
                <td>
                    <input type="text" name="otsikko" size="45"
                            value="<c:out value='${vaittama.otsikko}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Author: </th>
                <td>
                    <input type="text" name="vaite_teksti" size="45"
                            value="<c:out value='${vaittama.vaite_teksti}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
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
        </table>
        </form>
    </div>   
</body>
</html>