<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
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
                        <input type="number" name="quantidadeCamasCasal" id="quantidadeCamasCasal" min="0" value="${quarto.quantidadeCamasCasal}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="quantidadeCamasSolteiro">Quantidade de Camas de Solteiro:</label>
                    </td>
                    <td>
                        <input type="number" name="quantidadeCamasSolteiro" id="quantidadeCamasSolteiro" min="0" value="${quarto.quantidadeCamasSolteiro}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="ocupado">Ocupado:</label>
                    </td>
                    <td>
                        <input type="checkbox" name="ocupado" id="ocupado" value="$quarto.ocupado" <c:if test="${operacao == 'Excluir'}"> disabled </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="tipoQuarto">Tipo de Quarto:</label>
                    </td>
                    <td>
                        <select name="tipoQuarto" id="tipoQuarto">
                            <option value="0" <c:if test="${quarto.tipo.id == null}"> selected </c:if>></option>
                            <c:forEach items="${tiposQuarto}" var="tipoQuarto">
                                <option value="${tipoQuarto.id}" <c:if test="${quarto.tipo.id == tipoQuarto.id}">selected</c:if>>${tipoQuarto.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar">
        </form>
    </body>
</html>