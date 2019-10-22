<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pesquisa de Funcionários</title>
    </head>
    <body>
        <form action="ManterFuncionarioController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>id</th>
                    <th>CPF</th>
                    <th>Nome</th>
                    <th>Data Admissão</th>
                    <th colspan="2">Ação</th>
                </tr>
                <c:forEach items="${funcionarios}" var="funcionario">
                    <tr>
                        <td>
                            <c:out value="${funcionario.id}" />
                        </td>
                        <td>
                            <c:out value="${funcionario.nome}" />
                        </td>
                        <td>
                            <c:out value="${funcionario.cpf}" />
                        </td>
                        <td>
                            <c:out value="${funcionario.dataAdmissao}" />
                        </td>
                        <td>
                            <a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${funcionario.id}"/>">Editar</a>
                        </td>
                        <td>
                            <a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${funcionario.id}"/>"/>Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>