<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Consumo</title>
    </head>
    <body>
        <h1>Consumo - ${operacao}</h1>
        <form action="ManterConsumoController?acao=confirmarOperacao&operacao=${operacao}" method="post">
            <table>
                <tr>
                    <td>
                        <label for="data">Data de Nascimento:</label>
                    </td>
                    <td>
                        <input type="date" name="data" id="data" value="$consumo.data">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="quantidade">Quantidade:</label>
                    </td>
                    <td>
                        <input type="number" name="quantidade" id="quantidade" value="${consumo.quantidade}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="hospedagem">Hospedagem:</label>
                    </td>
                    <td>
                        <select name="hospedagem" id="hospedagem">
                            <option value="0" <c:if test="${consumo.hospedagem.id == null}"> selected </c:if>></option>
                            <c:forEach items="${hospedagens}" var="hospedagem">
                                <option value="${hospedagem.id}" <c:if test="${consumo.hospedagem.id == hospedagem.id}">selected</c:if>>${hospedagem.id}</option>
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
                                <option value="${item.codigo}" <c:if test="${consumo.item.codigo == item.codigo}">selected</c:if>>${item.descricao}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="funcionario">Funcionário Solicitante:</label>
                    </td>
                    <td>
                        <select name="FuncionarioSolicitante" id="FuncionarioSolicitante">
                            <option value="0" <c:if test="${consumo.funcionarioResponsavel.id == null}"> selected </c:if>></option>
                            <c:forEach items="${funcionarioSolicitante}" var="funcionario">
                                <option value="${funcionario.id}" <c:if test="${consumo.funcionarioResponsavel.id == funcionario.id}">selected</c:if>>${funcionario.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar">
        </form>
    </body>
</html>