<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<title>Cadastro Hóspede</title>
</head>
<title>Cadastrar Hóspede</title>
    </head>
    <body>
        <h1>Cadastrar Hóspede</h1>
        <form>    
        <table>
            <tr><td><label for="nome">Nome:</label> </td><td><input type="text" name="nome" id="nome" value="$acompanhante.nome"></td></tr>
            <tr><td><label for="telefone">Telefone:</label> </td><td><input type="text" name="telefone" id="telefone" value="$hospede.telefone"></td></tr>
            <tr><td><label for="email">E-mail:</label></td><td><input type="email" name="email" id="email" value="$hospede.email"></td></tr>
            <tr><td><label for="rg">RG:</label> </td><td><input type="text" name="rg" id="rg" value="$hospede.rg"></td></tr>
            <tr><td><label for="cpf">CPF</label></td><td><input type="text" name="cpf" id="cpf" value="$hospede.cpf"></td></tr>
            <tr><td><label for="passaporte">Passaporte</label></td><td><input type="text" name="passaporte" id="passaporte" value="$hospede.passaporte"></td></tr>
            <tr><td><label for="dataNascimento">Data de Nascimento:</label></td><td><input type="date" name="dataNascimento" id="dataNascimento" value="$hospede.dataNasicmento"></td></tr>
            <tr><td><label for="logradouro">Logradouro:</label></td><td><input type="text" name="logradouro" id="logradouro" value="$hospede.logradouro"></td></tr>
            <tr><td><label for="numeroResidencia">Número da Residência</label></td><td><input type="number" name="numeroResidencia" id="numeroResidencia" value="$hospede.numeroResidencia"></td></tr>
            <tr><td><label for="complemento">Complemento:</label></td><td><input type="text" name="complemento" id="complemento" value="$hospede.complemento"></td></tr>
            <tr><td><label for="bairro">Bairro:</label></td><td><input type="text" name="bairro" id="bairro" value="$hospede.bairro"></td></tr>
            <tr><td><label for="cidade">Cidade:</label></td><td><input type="text" name="cidade" id="cidade" value="$hospede.cidade"></td></tr>
            <tr><td><label for="estado">Estado:</label></td><td><input type="text" name="estado" id="estado" value="$hospede.estado"></td></tr>
            <tr><td><label for="cep">CEP:</label></td><td><input type="text" name="cep" id="cep" value="$hospede.cep"></td></tr>
        </table>
        <input type="submit" name="">
        </form>
    </body>
</html>