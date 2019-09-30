<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Cadastro Funcionário</title>
</head>

    <body>
        <h1>Cadastrar Funcionário</h1>
        <form>    
        <table>
            <tr><td><label for="nome">Nome:</label> </td><td><input type="text" name="nome" id="nome" value="$acompanhante.nome"></td></tr>
            <tr><td><label for="telefone">Telefone:</label> </td><td><input type="text" name="telefone" id="telefone" value="$funcionario.telefone"></td></tr>
            <tr><td><label for="email">E-mail:</label></td><td><input type="email" name="email" id="email" value="$funcionario.email"></td></tr>
            <tr><td><label for="rg">RG:</label> </td><td><input type="text" name="rg" id="rg" value="$funcionario.rg"></td></tr>
            <tr><td><label for="cpf">CPF</label></td><td><input type="text" name="cpf" id="cpf" value="$funcionario.cpf"></td></tr>
            <tr><td><label for="passaporte">Passaporte</label></td><td><input type="text" name="passaporte" id="passaporte" value="$funcionario.passaporte"></td></tr>
            <tr><td><label for="dataNascimento">Data de Nascimento:</label></td><td><input type="date" name="dataNascimento" id="dataNascimento" value="$funcionario.dataNasicmento"></td></tr>
            <tr><td><label for="logradouro">Logradouro:</label></td><td><input type="text" name="logradouro" id="logradouro" value="$funcionario.logradouro"></td></tr>
            <tr><td><label for="numeroResidencia">Número da Residência</label></td><td><input type="number" name="numeroResidencia" id="numeroResidencia" value="$funcionario.numeroResidencia"></td></tr>
            <tr><td><label for="complemento">Complemento:</label></td><td><input type="text" name="complemento" id="complemento" value="$funcionario.complemento"></td></tr>
            <tr><td><label for="bairro">Bairro:</label></td><td><input type="text" name="bairro" id="bairro" value="$funcionario.bairro"></td></tr>
            <tr><td><label for="cidade">Cidade:</label></td><td><input type="text" name="cidade" id="cidade" value="$funcionario.cidade"></td></tr>
            <tr><td><label for="estado">Estado:</label></td><td><input type="text" name="estado" id="estado" value="$funcionario.estado"></td></tr>
            <tr><td><label for="cep">CEP:</label></td><td><input type="text" name="cep" id="cep" value="$funcionario.cep"></td></tr>
            <tr><td><label for="categoriaFuncionario">Categoria do Funcionário:</label> </td><td>
                <select name="categoriaFuncionario" id="categoriaFuncionario">
                    <option value="0" <c:if test="${funcionario.categoriaFuncionario.id == null}"> selected </c:if>></option>
                <c: forEach items="${categoriasFuncionario}" var="categoriaFuncionario">
                    <option value="${categoriaFuncionario.id}" <c:if test="${funcionario.categoriaFuncionario.id == categoriaFuncionario.id}"></option>
                </c:forEach>
                </select>
            </td></tr>
        </table>
        <input type="submit" name="">
        </form>
    </body>
</html>