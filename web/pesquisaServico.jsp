<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pesquisa de Servicos</title>
    </head>
    <body>
        <form action="ManterServicoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>id</th>
                    <th>Nome</th>
                    <th>Pre�o</th>
                    <th>Tipo</th>
                    <th colspan="2">A��o</th>
                </tr>
                <c:forEach items="${servicos}" var="servico">
                    <tr>
                        <td>
                            <c:out value="${servico.codigo}" />
                        </td>
                        <td>
                            <c:out value="${servico.nome}" />
                        </td>
                        <td>
                            <c:out value="${servico.preco}" />
                        </td>
                        <td>
                            <c:out value="${servico.categoria}" />
                        </td>
                        <td>
                            <a href="ManterServicoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${servico.codigo}"/>">Editar</a>
                        </td>
                        <td>
                            <a href="ManterServicoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${servico.codigo}"/>"/>Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>