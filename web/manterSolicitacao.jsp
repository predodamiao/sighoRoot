<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitacao</title>
    </head>
    <body>
        <h1>Solicitacao - ${operacao}</h1>
        <form action="ManterSolicitacaoController?acao=confirmarOperacao&operacao=${operacao}" method="post">
            <table>
                <tr>
                    <td>
                        <label for="id">id:</label>
                    </td>
                    <td>
                        <input type="number" name="id" id="id" value="${pagamento.id}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="data">Data:</label>
                    </td>
                    <td>
                        <input type="date" name="data" id="data" value="${solicitacao.data}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="quantidade">Quantidade:</label>
                    </td>
                    <td>
                        <input type="number" name="quantidade" id="quantidade" value="${solicitacao.quantidade}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="hospedagem">Hospedagem:</label>
                    </td>
                    <td>
                        <select name="hospedagem" id="hospedagem">
                            <option value="0" <c:if test="${solicitacao.hospedagem.id == null}"> selected </c:if>></option>
                            <c:forEach items="${hospedagens}" var="hospedagem">
                                <option value="${hospedagem.id}" <c:if test="${solicitacao.hospedagem.id == hospedagem.id}"> selected </c:if>>${hospedagem.id}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="funcionarioSolicitante">Funcionário Solicitante:</label>
                    </td>
                    <td>
                        <select name="funcionarioSolicitante" id="funcionarioSolicitante">
                            <option value="0" <c:if test="${solicitacao.funcionarioSolicitante.id == null}"> selected </c:if>></option>
                            <c:forEach items="${funcionarios}" var="funcionario">
                                <option value="${funcionario.id}" <c:if test="${solicitacao.funcionarioSolicitante.id == funcionario.id}"> selected </c:if>>${funcionario.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="status">Status:</label>
                    </td>
                    <td>
                        <select name="status" id="status">
                            <option value="0" <c:if test="${solicitacao.status.id == null}"> selected </c:if>></option>
                            <c:forEach items="${status}" var="status">
                                <option value="${status.nomeStatus}" <c:if test="${solicitacao.status.id == status.id}"> selected </c:if>>${status.nomeStatus}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="item">Item:</label>
                    </td>
                    <td>
                        <select name="item" id="item">
                            <option value="0" <c:if test="${consumo.item.codigo == null}"> selected </c:if>></option>
                            <c:forEach items="${itens}" var="item">
                                <option value="${item.nome}" <c:if test="${consumo.item.codigo == item.codigo}">selected</c:if>>${item.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>

            <input type="submit" name="enviar">
        </form>
    </body>
</html>