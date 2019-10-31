<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hospedagem</title>
    </head>
    <body>
        <h1>Hospede - ${operacao}</h1>
        <form action="ManterHospedeController?acao=confirmarOperacao&operacao=${operacao}" method="post">
            <table>
                <tr>
                    <td>
                        <label for="id">ID:</label>
                    </td>
                    <td>
                        <input type="number" name="id" id="id" value="${hospede.id}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="nome">Nome:</label>
                    </td>
                    <td>
                        <input type="text" name="nome" id="nome" value="${hospede.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="telefone">Telefone:</label>
                    </td>
                    <td>
                        <input type="text" name="telefone" id="telefone" value="${hospede.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="email">E-mail:</label>
                    </td>
                    <td>
                        <input type="email" name="email" id="email" value="${hospede.email}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="rg">RG:</label>
                    </td>
                    <td>
                        <input type="text" name="rg" id="rg" value="${hospede.rg}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="cpf">CPF</label>
                    </td>
                    <td>
                        <input type="text" name="cpf" id="cpf" value="${hospede.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dataNascimento">Data de Nascimento:</label>
                    </td>
                    <td>
                        <input type="date" name="dataNascimento" id="dataNascimento" value="${hospede.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="passaporte">Passaporte</label>
                    </td>
                    <td>
                        <input type="text" name="passaporte" id="passaporte" value="${hospede.passaporte}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar">
        </form>
    </body>
</html>