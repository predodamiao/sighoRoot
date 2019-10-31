<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Item de Consumo</title>
    </head>
    <body>
        <h1>Item de Consumo - ${operacao}</h1>
        <form action="ManterItemConsumoController?acao=confirmarOperacao&operacao=${operacao}" method="post">
            <table>
                <tr>
                    <td>
                        <label for="codigo">Código:</label>
                    </td>
                    <td>
                        <input type="text" name="codigo" id="codigo" value="${itemConsumo.codigo}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="nome">Nome:</label>
                    </td>
                    <td>
                        <input type="text" name="nome" id="nome" value="${itemConsumo.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="descricao">Descrição:</label>
                    </td>
                    <td>
                        <textarea name="descricao" id="descricao" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>${itemConsumo.descricao}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="preco">Preco de Consumo:</label>
                    </td>
                    <td>
                        <input type="number" name="preco" id="preco" step="0.01" min="0.00" value="${itemConsumo.precoVenda}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar" value="${operacao}">
        </form>
    </body>
</html>