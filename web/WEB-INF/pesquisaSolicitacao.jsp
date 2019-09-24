<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Solicitações</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Descrição</th>
            </tr>
            <c:forEach items="${solicitacoes}" var="solicitacao">
                <tr>
                    <td><c:out value="${solicitacao.id}"/></td>
                    <td><c:out value="${solicitacao.descricao}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
