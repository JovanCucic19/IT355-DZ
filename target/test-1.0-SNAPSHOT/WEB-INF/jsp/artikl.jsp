<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<html xmlns:th="http://www.thymeleaf.org"> 
    <head> 
        <title>Dodavanje artikla</title> 
    </head> 
    <body>

        <%@include file="header.jsp" %>

        <form:form method="POST" action="artikl?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" >

            <div id="box">
                <h2>Unesite informacije o artiklu</h2>
                <table class="table">
                    <tr>
                        <td><form:label path="knjiga_naziv">Naziv knjige:</form:label></td>
                        <td><form:input id="knjiga_naziv" placeholder="naziv knjige" path="knjiga_naziv" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="knjiga_cena">Cena knjige:</form:label></td>
                        <td><form:input id="knjiga_cena" placeholder="cena knjige" path="knjiga_cena" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="knjiga_opis">Opis knjige:</form:label></td>
                        <td><form:input id="knjiga_opis" placeholder="opis knjige" path="knjiga_opis" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="knjiga_slika">Slika knjige:</form:label></td>
                        <td><input id="knjiga_slika" type="file"  class="form-control" name="file"/></td>       
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div id="box"> <input type="submit" value="posalji" class="btn-primary"/></div>
                        </td>
                    </tr>
                </table>
            </div>
        </form:form>

        <%@include file="footer.jsp" %> 