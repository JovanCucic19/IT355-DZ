<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@include file="header.jsp" %>

    <div id="box">
        <h1>Artikli:</h1>
        <c:if test="${!empty artikls}">
            <table>
                <tr>
                    <th width="350"> Naziv </th>
                    <th width="200"> Cena </th>
                </tr>
                <c:forEach items="${artikls}" var="artikl">
                    <tr>
                        <td>${artikl.knjiga_naziv}</td>
                        <td>${artikl.knjiga_cena}</td>
                        <td>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>

    <%@include file="footer.jsp" %> 