<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pesquisa de Pagamentos</title>
    </head>
    <body>
        <form action="ManterPagamentoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>id</th>
                    <th>Valor</th>
                    <th>Data</th>
                </tr>
                <c:forEach items="${pagamentos}" var="pagamento">
                    <tr>
                        <td>
                            <c:out value="${pagamento.id}" />
                        </td>
                        <td>
                            <c:out value="${pagamento.valor}" />
                        </td>
                        <td>
                            <c:out value="${pagamento.data}" />
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>