<%-- 
    Document   : cadastrarHospede
    Created on : 5 de set de 2019, 09:02:12
    Author     : Pedro Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Hóspede</title>
    </head>
    <body>
        <h1>Cadastrar de Hóspede</h1>
        <form>
            <table>
            <fieldset>
                
                <legend>Dados Pessoais</legend>

                <tr><td>Nome: </td><td><input type="text" name="nome"></td></tr>
                <tr><td>Telefone: </td><td><input type="text" name="telefone"></td></tr>
                <tr><td>E-mail: </td><td><input type="email" name="email"></td></tr>
                <tr><td>RG: </td><td><input type="text" name="rg"></td></tr>
                <tr><td>CPF: </td><td><input type="text" name="cpf"></td></tr>
                <tr><td>Passaporte: </td><td><input type="text" name="passaporte"></td></tr>
                <tr><td>Data de Nascimento: </td><td><input type="date" name="datanasc"></td></tr>
                
            </fieldset>
                </table>
        </form>
    </body>
</html>
