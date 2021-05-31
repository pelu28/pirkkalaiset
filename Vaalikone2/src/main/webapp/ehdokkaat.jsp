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
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/vaalikone"
        user="root" password="root"
    />
    
     
    <sql:query var="ehdokkaat"   dataSource="${myDS}">
        SELECT * FROM ehdokkaat;
    </sql:query>
    
    <style>
* {
  box-sizing: border-box;
}

#myInput {
 
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}

#myTable {
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #ddd;
  font-size: 18px;
}

#myTable th, #myTable td {
  text-align: left;
  padding: 12px;
}

#myTable tr {
  border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
  background-color: #f1f1f1;
}
</style>
     
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