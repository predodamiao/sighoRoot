<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pesquisa de Padrão Frigobar</title>
    </head>
    <body>
        <form action="ManterItemFrigobarController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>id</th>
                    <th>id Item</th>
                    <th>Quantidade</th>
                    <th colspan="2">Ação</th>
                </tr>
                <c:forEach items="${itensFrigobar}" var="itemFrigobar">
                    <tr>
                        <td>
                            <c:out value="${itemFrigobar.id}" />
                        </td>
                        <td>
                            <c:out value="${itemFrigobar.idItemConsumo}" />
                        </td>
                        <td>
                            <c:out value="${itemFrigobar.quantidade}" />
                        </td>
                        <td>
                            <a href="ManterItemFrigobarController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${itemFrigobar.id}"/>">Editar</a>
                        </td>
                        <td>
                            <a href="ManterItemFrigobarController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${itemFrigobar.id}"/>"/>Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>