<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Hóspedes</title>
    </head>
    <body>
        <form action="ManterHospedeController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>id</th>
                    <th>Nome</th>
                    <th>CPF</th>
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
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>