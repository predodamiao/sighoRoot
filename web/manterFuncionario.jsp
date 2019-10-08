<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Funcionário</title>
    </head>
    <body>
        <h1>Funcionário - ${operacao}</h1>
        <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="post">
            <table>
                <tr>
                    <td>
                        <label for="id">ID:</label>
                    </td>
                    <td>
                        <input type="number" name="id" id="id" value="${funcionario.id}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="nome">Nome:</label>
                    </td>
                    <td>
                        <input type="text" name="nome" id="nome" value="${acompanhante.nome}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="telefone">Telefone:</label>
                    </td>
                    <td>
                        <input type="text" name="telefone" id="telefone" value="${funcionario.telefone}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="email">E-mail:</label>
                    </td>
                    <td>
                        <input type="email" name="email" id="email" value="${funcionario.email}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="rg">RG:</label>
                    </td>
                    <td>
                        <input type="text" name="rg" id="rg" value="${funcionario.rg}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="cpf">CPF</label>
                    </td>
                    <td>
                        <input type="text" name="cpf" id="cpf" value="${funcionario.cpf}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="passaporte">Passaporte</label>
                    </td>
                    <td>
                        <input type="text" name="passaporte" id="passaporte" value="${funcionario.passaporte}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dataNascimento">Data de Nascimento:</label>
                    </td>
                    <td>
                        <input type="date" name="dataNascimento" id="dataNascimento" value="${funcionario.dataNascimento}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="categoriaFuncionario">Categoria do Funcionário:</label>
                    </td>
                    <td>
                        <select name="categoriaFuncionario" id="categoriaFuncionario">
                            <option value="0" <c:if test="${funcionario.categoriaFuncionario.id == null}"> selected </c:if>></option>
                            <c:forEach items="${categorias}" var="categoria">
                                <option value="${categoria.id}" <c:if test="${funcionario.categoriaFuncionario.id == categoria.id}">selected</c:if>>${categoria.nomeCategoria}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar">
        </form>
    </body>
</html>