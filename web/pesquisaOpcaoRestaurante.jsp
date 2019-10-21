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
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>