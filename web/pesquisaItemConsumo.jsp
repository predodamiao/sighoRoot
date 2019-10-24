<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pesquisa de Itens de Consumo</title>
    </head>
    <body>
        <form action="ManterItemConsumoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>id</th>
                    <th>Nome</th>
                    <th>Preço de Venda</th>
                    <th colspan="2">Ação</th>
                </tr>
                <c:forEach items="${itensConsumo}" var="itemConsumo">
                    <tr>
                        <td>
                            <c:out value="${itemConsumo.codigo}" />
                        </td>
                        <td>
                            <c:out value="${itemConsumo.nome}" />
                        </td>
                        <td>
                            R$ <c:out value="${itemConsumo.precoVenda}" />
                        </td>
                        <td>
                            <a href="ManterItemConsumoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${itemConsumo.codigo}"/>">Editar</a>
                        </td>
                        <td>
                            <a href="ManterItemConsumoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${itemConsumo.codigo}"/>"/>Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>