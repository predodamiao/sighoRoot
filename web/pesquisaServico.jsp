<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Servicos</title>
    </head>
    <body>
        <form action="ManterServicoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                </tr>
                <c:forEach items="${servicos}" var="servico">
                    <tr>
                        <td>
                            <c:out value="${servico.codigo}" />
                        </td>
                        <td>
                            <c:out value="${servico.nome}" />
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>