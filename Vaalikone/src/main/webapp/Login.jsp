<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vaalikone | Kirjaudu</title>
<link rel="stylesheet" type="text/css" href="styles.css"/>
</head>
<body>

    <div class="background" align="center">
    
        <h1>Vaalikoneen Hallinta | Kirjautuminen</h1>
        <form action="login" method="post">
        <div class="container">
            <label for="email">Sähköposti:</label>
            <input type="email" name="email" size="30" />
            <br><br>
            <label for="password">Salasana:</label>
            <input type="password" name="password" size="30" />
            <br><pre id="error">${message}</pre>
            <br><br>           
        <button type="submit" class="login">Kirjaudu</button>
        </div>
        </form>
    </div>
</body>
</html>