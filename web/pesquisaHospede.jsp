<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pesquisa de Hóspedes</title>
    </head>
    <body>
        <form action="ManterHospedeController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>id</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th colspan="2">Ação</th>
                </tr>
                <c:forEach items="${hospedes}" var="hospede">
                    <tr>
                        <td>
                            <c:out value="${hospede.id}" />
                        </td>
                        <td>
                            <c:out value="${hospede.nome}" />
                        </td>
                        <td>
                            <c:out value="${hospede.cpf}" />
                        </td>
                        <td>
                            <a href="ManterHospedeController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${hospede.id}"/>">Editar</a>
                        </td>
                        <td>
                            <a href="ManterHospedeController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${hospede.id}"/>"/>Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>