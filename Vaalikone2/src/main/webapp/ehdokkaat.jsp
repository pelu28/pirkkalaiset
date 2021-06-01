<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ehdokkaat</title>
  <link rel="stylesheet" type="text/css" href="styles.css"/>
</head>

<body>
 <a href="./etusivu.html" class="button1">Takaisin</a>
 <div class="background" align="center">
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/vaalikone"
        user="root" password="root"
    />
    
     
    <sql:query var="ehdokkaat"   dataSource="${myDS}">
        SELECT * FROM ehdokkaat;
    </sql:query>
    
  <h1>Ehdokkaiden selaaminen</h1>
 
     
    <div align="center">
    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Kirjoita puolueen nimi" title="Type in a name">
       <table id="myTable">
        
            <caption><h2>Lista ehdokkaista</h2></caption>
            <tr>
                <th>Puolue</th>
                <th>Nro</th>
                <th>Nimi</th>
                <th>Sukunimi</th>
                 <th>Postinumero</th>
                <th>Postitoimipaikka</th>
                 <th>Lähiosoite</th>
                <th>Miksi?</th>
            </tr>
            <c:forEach var="ehdokkaat" items="${ehdokkaat.rows}">
                <tr>
                    <td><c:out value="${ehdokkaat.puolue}" /></td>
                    <td><c:out value="${ehdokkaat.ehdokasnro}" /></td>
                    <td><c:out value="${ehdokkaat.etunimi}" /></td>
                    <td><c:out value="${ehdokkaat.sukunimi}" /></td>
                    <td><c:out value="${ehdokkaat.postinumero}" /></td>
                    <td><c:out value="${ehdokkaat.postitoimipaikka}" /></td>
                    <td><c:out value="${ehdokkaat.lahiosoite}" /></td>
                    <td><c:out value="${ehdokkaat.miksi}" /></td>
                    
                </tr>
            </c:forEach>
         
        </table>
        <a href="rest/ehdokkaatservice/all">Ehdokkaat JSON-muodossa</a>
        
    </div>
    <script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
</body>
</html>