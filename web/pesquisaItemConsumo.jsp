<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Itens de Consumo</title>
    </head>
    <body>
        <form action="ManterItemConsumoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                </tr>
                <c:forEach items="${itensConsumo}" var="itemConsumo">
                    <tr>
                        <td>
                            <c:out value="${itemConsumo.codigo}" />
                        </td>
                        <td>
                            <c:out value="${itemConsumo.descricao}" />
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>