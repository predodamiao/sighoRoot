<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <label for="nome">Nome:</label>
                    </td>
                    <td>
                        <input type="text" name="nome" id="nome" value="${tipoQuarto.nome}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="descricao">Descrição:</label>
                    </td>
                    <td>
                        <textarea name="descricao" id="descricao">${tipoQuarto.descricao}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="preco">Preço:</label>
                    </td>
                    <td>
                        <input type="number" name="preco" id="preco" value="${tipoQuarto.preco}">
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar">
        </form>
    </body>
</html>