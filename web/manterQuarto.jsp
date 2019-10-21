<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Quarto</title>
    </head>
    <body>
        <h1>Quarto - ${operacao}</h1>
        <form action="ManterQuartoController?acao=confirmarOperacao&operacao=${operacao}" method="post">
            <table>
                <tr>
                    <td>
                        <label for="identificacao">Identificação:</label>
                    </td>
                    <td>
                        <input type="text" name="identificacao" id="identificacao" value="${quarto.identificacao}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="quantidadeCamasCasal">Quantidade de Camas de Casal:</label>
                    </td>
                    <td>
                        <input type="number" name="quantidadeCamasCasal" id="quantidadeCamasCasal" min="0" value="${quarto.quantidadeCamasCasal}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="quantidadeCamasSolteiro">Quantidade de Camas de Solteiro:</label>
                    </td>
                    <td>
                        <input type="number" name="quantidadeCamasSolteiro" id="quantidadeCamasSolteiro" min="0" value="${quarto.quantidadesCamasSolteiro}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="ocupado">Ocupado:</label>
                    </td>
                    <td>
                        <input type="checkbox" name="ocupado" id="ocupado" value="$quarto.ocupado">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="tipoQuarto">Tipo de Quarto:</label>
                    </td>
                    <td>
                        <select name="tipoQuarto" id="tipoQuarto">
                            <option value="0" <c:if test="${quarto.tipoQuarto.id == null}"> selected </c:if>></option>
                            <c:forEach items="${tiposQuarto}" var="tipoQuarto">
                                <option value="${tipoQuarto.id}" <c:if test="${quarto.tipoQuarto.id == tipoQuarto.id}">selected</c:if>>${tipoQuarto.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar">
        </form>
    </body>
</html>