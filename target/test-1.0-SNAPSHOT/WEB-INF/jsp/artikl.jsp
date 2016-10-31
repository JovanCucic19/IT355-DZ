<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<html> 
    <head> 
        <title>Dodavanje artikla</title> 
    </head> 
    <body>

        <%@include file="header.jsp" %>


        <form:form method="POST" action="/WeShop/dodavanjeArtikla" commandName="artikl">
            
            <div id="box">
                <h2>Unesite informacije o studentu</h2>
                <table class="table">
                    <tr>
                        <td><form:label path="titl">Titl knjige:</form:label></td>
                        <td><form:input path="titl" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="cena">Cena knjige:</form:label></td>
                        <td><form:input path="cena" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="opis">Opis:</form:label></td>
                        <td><form:input path="opis" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div id="box"> <input type="submit" value="Pošalji" class="btn-primary"/></div>
                        </td>
                    </tr>
                </table>
            </div>
        </form:form>

        <%@include file="footer.jsp" %> 