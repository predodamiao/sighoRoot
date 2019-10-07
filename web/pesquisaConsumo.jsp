<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Consumo</title>
    </head>
    <body>
        <form action="ManterConsumoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>Data</th>
                    <th>Quantidade</th>
                </tr>
                <c:forEach items="${consumos}" var="consumo">
                    <tr>
                        <td>
                            <c:out value="${consumo.data}" />
                        </td>
                        <td>
                            <c:out value="${consumo.quantidade}" />
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>

</html>