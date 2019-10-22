<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pesquisa de Solicitações</title>
    </head>
    <body>
        <form action="ManterSolicitacaoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>Data</th>
                    <th>Quantidade</th>
                    <th>Status</th>
                    <th colspan="2">Ação</th>
                </tr>
                <c:forEach items="${solicitacoes}" var="solicitacao">
                    <tr>
                        <td>
                            <c:out value="${solicitacao.data}" />
                        </td>
                        <td>
                            <c:out value="${solicitacao.quantidade}" />
                        </td>
                        <td>
                            <c:out value="${solicitacao.status}" />
                        </td>
                        <td>
                            <a href="ManterSolicitacaoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${solicitacao.id}"/>">Editar</a>
                        </td>
                        <td>
                            <a href="ManterSolicitacaoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${solicitacao.id}"/>"/>Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>