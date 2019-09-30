<%-- 
    Document   : manterSolicitacao
    Created on : 27 de set de 2019, 11:03:50
    Author     : Pedro Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            <table>
                <tr><td><label for="data">Data:</label></td><td><input type="date" name="data" id="data" value="$solicitacao.data"></td></tr>
                <tr><td><label for="quantidade">Quantidade:</label></td><td><input type="number" name="quantidade" id="quantidade" value="$solicitacao.quantidade"></td></tr>
                <tr><td><label for="hospedagem">Hospedagem:</label></td><td>
                    <select name="hospedagem" id="hospedagem">
                        <option value="0" <c:if test="${solicitacao.hospedagem.id == null}"> selected </c:if>></option>
                    <c: forEach items="${hospedagens}" var="hospedagem">
                        <option value="${hospedagem.id}" <c:if test="${solicitacao.hospedagem.id == hospedagem.id}"></option>
                    </c:forEach>
                    </select>
                </td></tr>
                <tr><td><label for="solicitante">Solicitante:</label></td><td>
                    <select name="solicitante" id="solicitante">
                        <option value="0" <c:if test="${solicitacao.solicitante.id == null}"> selected </c:if>></option>
                    <c: forEach items="${solicitantes}" var="solicitante">
                        <option value="${solicitante.id}" <c:if test="${solicitacao.solicitante.id == solicitante.id}"></option>
                    </c:forEach>
                    </select>
                </td></tr>
                <tr><td><label for="status">Status:</label></td><td>
                    <select name="status" id="status">
                        <option value="0" <c:if test="${solicitacao.status.id == null}"> selected </c:if>></option>
                    <c: forEach items="${statuss}" var="status">
                        <option value="${status.id}" <c:if test="${solicitacao.status.id == status.id}"></option>
                    </c:forEach>
                    </select>
                </td></tr>
            </table>
        </form>
    </body>
</html>
