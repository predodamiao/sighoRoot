<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pesquisa de Itens de Restaurante</title>
    </head>
    <body>
        <form action="ManterOpcaoRestauranteController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>id</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th colspan="2">Ação</th>
                </tr>
                <c:forEach items="${itensRestaurante}" var="itemRestaurante">
                    <tr>
                        <td>
                            <c:out value="${itemRestaurante.codigo}" />
                        </td>
                        <td>
                            <c:out value="${itemRestaurante.nome}" />
                        </td>
                        <td>
                            <c:out value="${itemRestaurante.preco}" />
                        </td>
                        <td>
                            <a href="ManterOpcaoRestauranteController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${opcaoRestaurante.id}"/>">Editar</a>
                        </td>
                        <td>
                            <a href="ManterOpcaoRestauranteController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${opcaoRestaurante.id}"/>"/>Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>