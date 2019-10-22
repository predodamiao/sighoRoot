<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pesquisa de Tipos de Quarto</title>
    </head>
    <body>
        <form action="ManterTipoQuartoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>id</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th colspan="2">Ação</th> 
                </tr>
                <c:forEach items="${tiposQuarto}" var="tipoQuarto">
                    <tr>
                        <td>
                            <c:out value="${tipoQuarto.id}" />
                        </td>
                        <td>
                            <c:out value="${tipoQuarto.nome}" />
                        </td>
                        <td>
                            <c:out value="${tipoQuarto.preco}" />
                        </td>
                        <td>
                            <a href="ManterTipoQuartoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${tipoQuarto.id}"/>">Editar</a>
                        </td>
                        <td>
                            <a href="ManterTipoQuartoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${tipoQuarto.id}"/>"/>Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>