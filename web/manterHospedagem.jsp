<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hospedagem</title>
    </head>
    <body>
        <h1>Hospedagem - ${operacao}</h1>
        <form action="ManterHospedagemController?acao=confirmarOperacao&operacao=${operacao}" method="post">
            <table>
                <tr>
                    <td>
                        <label for="id">id</label>
                    </td>
                    <td>
                        <input type="number" name="id" id="id" value="${hospedagem.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dataChegada">Chegada:</label>
                    </td>
                    <td>
                        <input type="date" name="dataChegada" id="dataChegada" value="${hospedagem.dataChegada}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dataSaida">Saída:</label>
                    </td>
                    <td>
                        <input type="date" name="dataSaida" id="dataSaida" value="${hospedagem.dataSaida}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dataEstimadaChegada">Chegada Estimada:</label>
                    </td>
                    <td>
                        <input type="date" name="dataEstimadaChegada" id="dataEstimadaChegada" value="${hospedagem.dataEstimadaChegada}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dataEstimadaSaida">Saída Estimada:</label>
                    </td>
                    <td>
                        <input type="date" name="dataEstimadaSaida" id="dataEstimadaSaida" value="${hospedagem.dataEstimadaSaida}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="checked">Checked:</label>
                    </td>
                    <td>
                        <input type="checkbox" name="checked" id="checked" <c:if test="${hospedagem.checked == true}">checked</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="hospede">Hospede Responsável:</label>
                    </td>
                    <td>
                        <select name="hospede" id="hospede">
                            <option value="0" <c:if test="${hospedagem.hospedeResponsavel.id == null}"> selected </c:if>></option>
                            <c:forEach items="${hospedes}" var="hospede">
                                <option value="${hospede.id}" <c:if test="${hospedagem.hospedeResponsavel.id == hospede.id}">selected</c:if>>${hospede.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="quarto">Quarto:</label>
                    </td>
                    <td>
                        <select name="quarto" id="quarto">
                            <option value="0" <c:if test="${hospedagem.quarto.identificacao == null}"> selected </c:if>></option>
                            <c:forEach items="${quartos}" var="quarto">
                                <option value="${quarto.identificacao}" <c:if test="${hospedagem.quarto.identificacao == quarto.identificacao}">selected</c:if>>${quarto.identificacao}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="tipoQuarto">Tipo de Quarto:</label>
                    </td>
                    <td>
                        <select name="tipoQuarto" id="tipoQuarto" <c:if test="${operacao == 'Excluir'}"> disabled </c:if>>
                            <option value="0" <c:if test="${hospedagem.tipoQuarto.id == null}"> selected </c:if>></option>
                            <c:forEach items="${tiposQuarto}" var="tipoQuarto">
                                <option value="${tipoQuarto.id}" <c:if test="${hospedagem.tipoQuarto.id == tipoQuarto.id}">selected</c:if>>${tipoQuarto.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar" value="${operacao}">
        </form>
    </body>
</html>