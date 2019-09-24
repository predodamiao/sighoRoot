<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Padrão Frigobar</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Descrição</th>
            </tr>
            <c:forEach items="${tiposQuarto}" var="tipoQuarto">
                <tr>
                    <td><c:out value="${tipoQuarto.id}"/></td>
                    <td><c:out value="${tipoQuarto.descricao}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
