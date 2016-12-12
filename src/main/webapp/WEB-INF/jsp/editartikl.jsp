<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="false" %>
<html>
    <body>
        <%@include file="header.jsp" %>

        <div class="container">

            <h1>Edit Artikl</h1>  
            <form:form method="POST" action="/WeShop/editsave" >    
                <table class="table">    
                    <tr>  
                       <td>Naziv : </td>   
                       <td><form:input id="knjiga_id" path="knjiga_id"  class="form-control"/></td>  
                    </tr>   
                    <tr>    
                        <td>Naziv : </td>   
                        <td><form:input id="knjiga_naziv" path="knjiga_naziv"  class="form-control"/></td>  
                    </tr>    
                    <tr>    
                        <td>Cena :</td>    
                        <td><form:input id="knjiga_cena" path="knjiga_cena" class="form-control"/></td>  
                    </tr>   
                    <tr>    
                        <td>Opis :</td>    
                        <td><form:input id="knjiga_opis" path="knjiga_opis" class="form-control"/></td>  
                    </tr>   

                    <tr>
                        <td><input type="submit" value="Edit Save" /></td>    
                    </tr>    
                </table>    
            </form:form>  
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>