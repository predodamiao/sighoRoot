<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pesquisa de Quartos</title>
    </head>
    <body>
        <form action="ManterQuartoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>Identificacao</th>
                    <th>Ocupado</th>
                    <th>id Tipo</th>
                    <th colspan="2">Ação</th>
                </tr>
                <c:forEach items="${quartos}" var="quarto">
                    <tr>
                        <td>
                            <c:out value="${quarto.identificacao}" />
                        </td>
                        <td>
                            <c:out value="${quarto.ocupado}" />
                        </td>
                        <td>
                            <c:out value="${quarto.idTipoQuarto}" />
                        </td>
                        <td>
                            <a href="ManterQuartoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${quarto.identificacao}"/>">Editar</a>
                        </td>
                        <td>
                            <a href="ManterQuartoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${quarto.identificacao}"/>"/>Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>

</html>