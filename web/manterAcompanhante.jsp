<%-- 
    Document   : cadastrarAcompanhante
    Created on : 26/09/2019, 09:12:12
    Author     : Lavínia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro Acompanhante</title>
    </head>
    <body>
        <h1>Cadastrar Acompanhante</h1>
        <form>    
        <table>
            <tr><td><label for="nome">Nome:</label> </td><td><input type="text" name="nome" id="nome" value="$acompanhante.nome"></td></tr>
            <tr><td><label for="dataNascimento">Data de Nascimento:</label> </td><td><input type="date" name="dataNascimento" id="dataNascimento" value="$(acompanhante.dataNascimento"></td></tr>           
            <tr><td><label for="ocupaCama">Camas Ocupadas:</label></td><td><input type="ocupaCama" name="ocupaCama" id="ocupaCama"></td></tr>
            <tr><td><label for="hospedagem">Hospedagem</label></td><td>
                <select name="hospedagem" id="hospedagem">
                    <option value="0" <c:if test="${acompanhante.hospedagem.id == null}"> selected </c:if>></option>
                <c: forEach items="${hospedagens}" var="hospedagem">
                    <option value="${hospedagem.id}" <c:if test="${acompanhante.hospedagem.id == hospedagem.id}"></option>
                </c:forEach>
                </select>
            </td></tr>
        </table>
        <input type="submit" name="">
        </form>
    </body>
</html>
