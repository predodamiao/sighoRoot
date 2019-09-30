<!DOCTYPE html>
<html>
<head>
    <title>Cadastrar Opção Restaurante </title>
</head>
<body>
        <h1>Cadastrar Opção Restaurante    </h1>
    <form>
        <table>
            <tr><td><label for="nome">Nome:</label> </td><td><input type="text" name="nome" id="nome" value="$opcaoRestaurante.nome"></td></tr>    
            <tr><td><label for="descricao">Descrição:</label> </td><td><textarea name="descricao" id="descricao" value="$opcaoRestaurante.descricao"></textarea></td></tr>
            <tr><td><label for="preco">Preco de Consumo:</label> </td><td><input type="number" name="preco" id="preco" step="0.10" min="0.00" value="$opcaoRestaurante.preco"></td></tr>
            <tr><td><label for="acrescimo">Acréscimo para servir no quarto:</label> </td><td><input type="number" name="acrescimo" id="acrescimo" step="0.10" min="0.00" value="$opcaoRestaurante.acrescimo"></td></tr>
            <tr><td><label for="tempo">Tempo Preparo:</label> </td><td><input type="number" name="tempo" id="tempo" step="0.10" min="0.00" value="$opcaoRestaurante.tempo"></td></tr>
        </table>
        <input type="submit" name="">
    </form>
    </body>
</html>