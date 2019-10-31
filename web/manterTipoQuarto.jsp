<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tipo de Quarto</title>
    </head>
    <body>
        <h1>Tipo de Quarto - ${operacao}</h1>
        <form action="ManterTipoQuartoController?acao=confirmarOperacao&operacao=${operacao}" method="post">
            <table>
                <tr>
                    <td>
                        <label for="id">ID:</label>
                    </td>
                    <td>
                        <input type="number" name="id" id="id" value="${tipoQuarto.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="nome">Nome:</label>
                    </td>
                    <td>
                        <input type="text" name="nome" id="nome" value="${tipoQuarto.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="descricao">Descrição:</label>
                    </td>
                    <td>
                        <textarea name="descricao" id="descricao" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>${tipoQuarto.descricao}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="preco">Preço:</label>
                    </td>
                    <td>
                        <input type="number" step="0.01" min="0.00" name="preco" id="preco" value="${tipoQuarto.preco}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar" value="${operacao}">
        </form>
    </body>
</html>