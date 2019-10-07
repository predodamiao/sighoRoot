<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Acompanhantes</title>
    </head>
    <body>
        <form action="ManterAcompanhanteController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>Nome</th>
                    <th>Ocupa Campa</th>
                </tr>
                <c:forEach items="${acompanhantes}" var="acompanhante">
                    <tr>
                        <td>
                            <c:out value="${acompanhante.nome}" />
                        </td>
                        <td>
                            <c:out value="${acompanhante.ocupaCama}" />
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>