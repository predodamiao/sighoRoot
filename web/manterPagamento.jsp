<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Pagamento</title>
</head>
<body>
        <h1>Pagemento - ${operacao}</h1>
    <form>
        <table>
            <tr><td><label for="data">Data :</label></td><td><input type="date" name="data" id="data" value="${pagamento.data}"></td></tr>
            <tr><td><label for="hospedagem">Hospedagem:</label></td><td>
                <select name="hospedagem" id="hospedagem">
                    <option value="0" <c:if test="${pagamento.hospedagem.id == null}"> selected </c:if>></option>
                <c:forEach items="${hospedagens}" var="hospedagem">
                    <option value="${hospedagem.id}" <c:if test="${pagamento.hospedagem.id == hospedagem.id}">selected</c:if>>${hospedagem.id}</option>
                </c:forEach>
                </select>
            </td></tr>
            <tr><td><label for="tipo">Tipo de Pagamento:</label></td><td>
                <select name="tipo" id="tipo">
                    <option value="0" <c:if test="${pagamento.hospedagem.id == null}"> selected </c:if>></option>
                <c:forEach items="${tipos}" var="tipo">
                    <option value="${tipo.id}" <c:if test="${pagamento.tipo.id == tipo.id}">selected </c:if>></option>
                </c:forEach>
                </select>
            </td></tr>
            <tr><td><label for="valor">Valor:</label> </td><td><input type="number" name="valor" id="valor" value="${pagamento.valor}"></td></tr>
            <tr><td><label for="parcelas">Parcelar:</label></td><td><input type="number" name="parcelas" id="parcelas" value="${pagamento.parcelas}"></td></tr>

        </table>
        <input type="submit" name="enviar">
    </form>
</body>
</html>