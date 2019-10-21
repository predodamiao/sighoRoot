<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pagamento</title>
    </head>
    <body>
        <h1>Pagemento - ${operacao}</h1>
        <form action="ManterPagamentoController?acao=confirmarOperacao&operacao=${operacao}" method="post">
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
                <tr>
                    <td>
                        <label for="data">Data:</label>
                    </td>
                    <td>
                        <input type="date" name="data" id="data" value="${pagamento.data}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="hospedagem">Hospedagem:</label>
                    </td>
                    <td>
                        <select name="hospedagem" id="hospedagem">
                            <option value="0" <c:if test="${pagamento.hospedagem.id == null}"> selected </c:if>></option>
                            <c:forEach items="${hospedagens}" var="hospedagem">
                                <option value="${hospedagem.id}" <c:if test="${pagamento.hospedagem.id == hospedagem.id}">selected</c:if>>${hospedagem.id}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="tipo">Tipo de Pagamento:</label>
                    </td>
                    <td>
                        <select name="tipo" id="tipo">
                            <option value="0" <c:if test="${pagamento.tipo.id == null}"> selected </c:if>></option>
                            <c:forEach items="${tipos}" var="tipo">
                                <option value="${tipo.nomeTipo}" <c:if test="${pagamento.tipo.id == tipo.id}">selected </c:if>>${tipo.nomeTipo}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="tipo">Momento do Pagamento:</label>
                    </td>
                    <td>
                        <select name="momento" id="momento">
                            <option value="0" <c:if test="${pagamento.momento.id == null}"> selected </c:if>></option>
                            <c:forEach items="${momentos}" var="momento">
                                <option value="${momento.nomeMomento}" <c:if test="${pagamento.momento.id == momento.id}">selected </c:if>>${momento.nomeMomento}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="valor">Valor:</label>
                    </td>
                    <td>
                        <input type="number" name="valor" id="valor" value="${pagamento.valor}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="parcelas">Parcelar:</label>
                    </td>
                    <td>
                        <input type="number" name="parcelas" id="parcelas" value="${pagamento.parcelas}">
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar">
        </form>
    </body>
</html>