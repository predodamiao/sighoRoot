<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
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
                        <input type="text" name="nome" id="nome" value="${funcionario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="telefone">Telefone:</label>
                    </td>
                    <td>
                        <input type="text" name="telefone" id="telefone" value="${funcionario.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="email">E-mail:</label>
                    </td>
                    <td>
                        <input type="email" name="email" id="email" value="${funcionario.email}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="rg">RG:</label>
                    </td>
                    <td>
                        <input type="text" name="rg" id="rg" value="${funcionario.rg}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="cpf">CPF</label>
                    </td>
                    <td>
                        <input type="text" name="cpf" id="cpf" value="${funcionario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dataNascimento">Data de Nascimento:</label>
                    </td>
                    <td>
                        <input type="date" name="dataNascimento" id="dataNascimento" value="${funcionario.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dataAdmissao">Data da Admissão:</label>
                    </td>
                    <td>
                        <input type="date" name="dataAdmissao" id="dataAdmissao" value="${funcionario.dataAdmissao}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="categoriaFuncionario">Categoria do Funcionário:</label>
                    </td>
                    <td>
                        <select name="categoriaFuncionario" id="categoriaFuncionario">
                            <option value="0" <c:if test="${funcionario.categoria.id == null}"> selected </c:if>></option>
                            <c:forEach items="${categorias}" var="categoria">
                                <option value="${categoria.nomeCategoria}" <c:if test="${funcionario.categoria.id == categoria.id}">selected</c:if>>${categoria.nomeCategoria}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar">
        </form>
    </body>
</html>