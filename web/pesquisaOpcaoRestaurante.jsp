<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Itens de Restaurante</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>Descrição</th>
                <th>Preço Venda</th>
            </tr>
            <c:forEach items="${itensRestaurante}" var="itemRestaurante">
                <tr>
                    <td><c:out value="${itemRestaurante.descricao}"/></td>
                    <td><c:out value="${itemRestaurante.precoVenda}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
