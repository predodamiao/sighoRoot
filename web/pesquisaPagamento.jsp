<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Pagamentos</title>
    </head>
    <body>
        <form action="ManterPagamentoController?acao=prepararOperacao&operacao=Incluir" method="post">
        <table border="1">
            <tr>
                <th>Valor</th>
            </tr>
            <c:forEach items="${pagamentos}" var="pagamento">
                <tr>
                    <td><c:out value="${pagamento.valor}"/></td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" name="btnIncluir" value="Incluir"/>
        </form>
    </body>
</html>
