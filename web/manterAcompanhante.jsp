<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Acompanhante</title>
    </head>
    <body>
        <h1>Acompanhante - ${operacao}</h1>
        <form>
            <table>
                <tr>
                    <td>
                        <label for="id">ID:</label>
                    </td>
                    <td>
                        <input type="number" name="id" id="id" value="${acompanhante.id}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="nome">Nome:</label>
                    </td>
                    <td>
                        <input type="text" name="nome" id="nome" value="${acompanhante.nome}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dataNascimento">Data de Nascimento:</label>
                    </td>
                    <td>
                        <input type="date" name="dataNascimento" id="dataNascimento" value="${acompanhante.dataNascimento}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="ocupaCama">Ocupa Cama?</label>
                    </td>
                    <td>
                        <input type="checkbox" name="ocupaCama" id="ocupaCama">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="hospedagem">Hospedagem</label>
                    </td>
                    <td>
                        <select name="hospedagem" id="hospedagem">
                            <option value="0" <c:if test="${acompanhante.hospedagem.id == null}">selected</c:if>></option>
                            <c:forEach items="${hospedagens}" var="hospedagem">
                                <option value="${hospedagem.id}" <c:if test="${acompanhante.hospedagem.id == hospedagem.id}">selected</c:if>>${hospedagem.id}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar">
        </form>
    </body>
</html>