<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Pesquisa de Acompanhantes</title>
    </head>
    <body>
        <form action="ManterAcompanhanteController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>id</th>
                    <th>Nome</th>
                    <th>DataNascimeto</th>
                    <th>idHospedagem</th>
                </tr>
                <c:forEach items="${acompanhantes}" var="acompanhante">
                    <tr>
                        <td>
                            <c:out value="${acompanhante.id}" />
                        </td>
                        <td>
                            <c:out value="${acompanhante.nome}" />
                        </td>
                        <td>
                            <c:out value="${acompanhante.dataNascimento}" />
                        </td>
                        <td>
                            <c:out value="${acompanhante.idHospedagem}" />
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>