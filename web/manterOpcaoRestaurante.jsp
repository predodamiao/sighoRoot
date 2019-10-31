<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Opção Restaurante</title>
    </head>
    <body>
        <h1>Opção Restaurante - ${operacao}</h1>
        <form action="ManterOpcaoRestauranteController?acao=confirmarOperacao&operacao=${operacao}" method="post">
            <table>

                <tr>
                    <td>
                        <label for="codigo">Código:</label>
                    </td>
                    <td>
                        <input type="text" name="codigo" id="codigo" value="${opcaoRestaurante.codigo}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="nome">Nome:</label>
                    </td>
                    <td>
                        <input type="text" name="nome" id="nome" value="${opcaoRestaurante.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="descricao">Descrição:</label>
                    </td>
                    <td>
                        <textarea name="descricao" id="descricao" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>${opcaoRestaurante.descricao}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="preco">Preco de Consumo:</label>
                    </td>
                    <td>
                        <input type="number" name="preco" id="preco" step="0.01" min="0.00" value="${opcaoRestaurante.preco}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="Acrescimo">Acrescimo para servir no Quarto:</label>
                    </td>
                    <td>
                        <input type="number" name="acrescimo" id="acrescimo" step="0.01" min="0.00" value="${opcaoRestaurante.acrescimo}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="preco">Tempo de Preparo:</label>
                    </td>
                    <td>
                        <input type="number" name="tempoPreparo" id="tempoPreparo" step="1" min="0" value="${opcaoRestaurante.tempoPreparo}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="categoriaOpcaoRestaurante">Categoria:</label>
                    </td>
                    <td>
                        <select name="categoriaOpcaoRestaurante" id="categoriaOpcaoRestaurante" disabled>
                            <option value="0"></option>
                            <option value="Restaurante" selected>Restaurante</option>

                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar">
        </form>
    </body>
</html>