<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Cadastro Consumo</title>
</head>

    <body>
        <h1>Cadastrar Consumo</h1>
        <form>    
        <table>
            <tr><td><label for="data">Data de Nascimento:</label></td><td><input type="date" name="data" id="data" value="$consumo.data"></td></tr>
            <tr><td><label for="quantidade">Quantidade:</label></td><td><input type="number" name="quantidade" id="quantidade" value="$consumo.quantidade"></td></tr>
            <tr><td><label for="hospedagem">Hospedagem:</label></td><td>
                <select name="hospedagem" id="hospedagem">
                    <option value="0" <c:if test="${consumo.hospedagem.id == null}"> selected </c:if>></option>
                <c: forEach items="${hospedagens}" var="hospedagem">
                    <option value="${hospedagem.id}" <c:if test="${consumo.hospedagem.id == hospedagem.id}"></option>
                </c:forEach>
                </select>
            </td></tr>
            <tr><td><label for="item">Item:</label></td><td>
                <select name="item" id="item">
                    <option value="0" <c:if test="${consumo.item.id == null}"> selected </c:if>></option>
                <c: forEach items="${itens}" var="item">
                    <option value="${item.id}" <c:if test="${consumo.item.id == item.id}"></option>
                </c:forEach>
                </select>
            </td></tr>
            <tr><td><label for="solicitante">Solicitante:</label></td><td>
                    <select name="solicitante" id="solicitante">
                        <option value="0" <c:if test="${consumo.solicitante.id == null}"> selected </c:if>></option>
                    <c: forEach items="${solicitantes}" var="solicitante">
                        <option value="${solicitante.id}" <c:if test="${consumo.solicitante.id == solicitante.id}"></option>
                    </c:forEach>
                    </select>
                </td></tr>
        </table>
        <input type="submit" name="">
        </form>
    </body>
</html>