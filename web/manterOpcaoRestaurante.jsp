<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Opção Restaurante</title>
</head>
<body>
        <h1>Opção Restaurante - ${operacao}</h1>
    <form>
        <table>
            <tr><td><label for="nome">Nome:</label> </td><td><input type="text" name="nome" id="nome" value="${opcaoRestaurante.nome}"></td></tr>    
            <tr><td><label for="descricao">Descrição:</label> </td><td><textarea name="descricao" id="descricao">${opcaoRestaurante.descricao}</textarea></td></tr>
            <tr><td><label for="preco">Preco de Consumo:</label> </td><td><input type="number" name="preco" id="preco" step="0.10" min="0.00" value="${opcaoRestaurante.preco}"></td></tr>
            <tr><td><label for="acrescimo">Acréscimo para servir no quarto:</label> </td><td><input type="number" name="acrescimo" id="acrescimo" step="0.10" min="0.00" value="${opcaoRestaurante.acrescimo}"></td></tr>
            <tr><td><label for="tempo">Tempo Preparo:</label> </td><td><input type="number" name="tempo" id="tempo" step="1" min="0.00" value="${opcaoRestaurante.tempo}"></td></tr>
        </table>
        <input type="submit" name="enviar">
    </form>
    </body>
</html>