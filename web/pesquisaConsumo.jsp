<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pesquisa de Consumo</title>
    </head>
    <body>
        <form action="ManterConsumoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>id</th>
                    <th>Data</th>
                    <th>Quantidade</th>
                    <th>id Item Consumido</th>
                    <th colspan="2">Ação<th>
                </tr>
                <c:forEach items="${consumos}" var="consumo">
                    <tr>
                        <td>
                            <c:out value="${consumo.id}" />
                        </td>
                        <td>
                            <c:out value="${consumo.data}" />
                        </td>
                        <td>
                            <c:out value="${consumo.quantidade}" />
                        </td>
                        <td>
                            <c:out value="${consumo.idItemConsumido}" />
                        </td>
                        <td>
                            <a href="ManterConsumoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${consumo.id}"/>">Editar</a>
                        </td>
                        <td>
                            <a href="ManterConsumoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${consumo.id}"/>"/>Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>

</html>