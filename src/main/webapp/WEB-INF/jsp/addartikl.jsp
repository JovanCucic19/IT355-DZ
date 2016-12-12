<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;
              charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <form:form method="POST" modelAttribute="student">
        <form:label path="knjiga_naziv"> Naziv kn </form:label>
        <form:input id="knjiga_naziv" placeholder="ime" path="ime" />
        
        <form:label path="prezime"> Prezime </form:label>
        <form:input id="prezime" placeholder="prezime" path="prezime" />
        
        <button type="submit">Dodaj</button>
    </form:form>
</body>
</html>