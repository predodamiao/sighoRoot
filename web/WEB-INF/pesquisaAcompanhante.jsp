<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Acompanhantes</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>CPF</th>
                <th>Nome</th>
            </tr>
            <c:forEach items="${acompanhantes}" var="acompanhante">
                <tr>
                    <td><c:out value="${acompanhante.cpf}"/></td>
                    <td><c:out value="${acompanhante.nome}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
