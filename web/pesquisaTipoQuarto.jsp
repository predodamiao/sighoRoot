<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Tipos de Quarto</title>
    </head>
    <body>
        <form action="ManterTipoQuartoController?acao=prepararOperacao&operacao=Incluir" method="post">
        <table border="1">
            <tr>
                <th>Preco</th>
                <th>Descrição</th>
            </tr>
            <c:forEach items="${tiposQuarto}" var="tipoQuarto">
                <tr>
                    <td><c:out value="${tipoQuarto.preco}"/></td>
                    <td><c:out value="${tipoQuarto.descricao}"/></td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" name="btnIncluir" value="Incluir"/>
        </form>
    </body>
</html>
