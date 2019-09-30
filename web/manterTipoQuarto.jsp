<!DOCTYPE html>
<html>
<head>
	<title>Cadastro Tipo de Quarto</title>
</head>

    <body>
        <h1>Cadastrar Tipo de Quarto</h1>
        <form>    
        <table>
            <tr><td><label for="nome">Nome:</label> </td><td><input type="text" name="nome" id="nome" value="$tipoQuarto.nome"></td></tr>
            <tr><td><label for="descricao">Descrição:</label> </td><td><textarea name="descricao" id="descricao" value="$tipoQuarto.descricao"></textarea></td></tr>
            <tr><td><label for="preco">Preço:</label> </td><td><input type="number" name="preco" id="preco" value="$tipoQuarto.preco"></td></tr>
        </table>
        <input type="submit" name="">
        </form>
    </body>
</html>