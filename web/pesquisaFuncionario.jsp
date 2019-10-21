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
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>