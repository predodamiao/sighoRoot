<!DOCTYPE html>
<html>
<head>
	<title>Cadastro Item de Consumo </title>
</head>
<body>
        <h1>Cadastrar Item de Consumo    </h1>
    <form>
        <table>
            <tr><td><label for="nome">Nome:</label> </td><td><input type="text" name="nome" id="nome" value="$itemConsumo.nome"></td></tr>  
            <tr><td><label for="codigo">Código:</label> </td><td><input type="text" name="codigo" id="codigo" value="$itemConsumo.codigo"></td></tr>  
            <tr><td><label for="autocode">Gerar Código:</label> </td><td><input type="checkbox" name="autocode" id="autocode" ></td></tr>  
            <tr><td><label for="descricao">Descrição:</label> </td><td><textarea name="descricao" id="descricao" value="$itemConsumo.descricao"></textarea></td></tr>
            <tr><td><label for="preco">Preco de Consumo:</label> </td><td><input type="number" name="preco" id="preco" step="0.10" min="0.00" value="$itemConsumo.preco"></td></tr>
        </table>
        <input type="submit" name="">
    </form>
</body>
</html>