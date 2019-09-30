<!DOCTYPE html>
<html>
<head>
	<title>Cadastro Hospedagem</title>
</head>

    <body>
        <h1>Cadastrar Hospedagem</h1>
        <form>    
        <table>
            <tr><td><label for="dataChegada">Chegada:</label> </td><td><input type="datetime-local" name="dataChegada" id="dataChegada" value="$hospedagem.dataChegada"></td></tr>
            <tr><td><label for="dataSaida">Saída</label> </td><td><input type="datetime-local" name="dataSaida" id="dataSaida" value="$hospedagem.dataSaida"></td></tr>
            <tr><td><label for="dataEstimadaChegada">Chegada:</label> </td><td><input type="datetime-local" name="dataEstimadaChegada" id="dataEstimadaChegada" value="$hospedagem.dataEstimadaChegada"></td></tr>
            <tr><td><label for="dataEstimadaSaida">Saída</label> </td><td><input type="datetime-local" name="dataEstimadaSaida" id="dataEstimadaSaida" value="$hospedagem.dataEstimadaSaida"></td></tr>
            <tr><td><label for="checked">Checked:</label> </td><td><input type="checkbox" name="dataEstimadaSaida" id="checked" value="$hospedagem.checked"></td></tr>
            <tr><td><label for="hospede">Hospede Responsável:</label></td><td>
                <select name="hospede" id="hospede">
                    <option value="0" <c:if test="${hospedagem.hospede.id == null}"> selected </c:if>></option>
                <c: forEach items="${hospedes}" var="hospede">
                    <option value="${hospede.id}" <c:if test="${hospededagem.hospede.id == hospede.id}"></option>
                </c:forEach>
                </select>
            </td></tr>
            <tr><td><label for="quarto">Quarto:</label></td><td>
                <select name="quarto" id="quarto">
                    <option value="0" <c:if test="${hospedagem.quarto.id == null}"> selected </c:if>></option>
                <c: forEach items="${quartos}" var="quarto">
                    <option value="${quarto.id}" <c:if test="${hospedagem.quarto.id == quarto.id}"></option>
                </c:forEach>
                </select>
            </td></tr>
            <tr><td><label for="tipoQuarto">Tipo de Quarto:</label></td><td>
                <select name="tipoQuarto" id="tipoQuarto">
                    <option value="0" <c:if test="${hospedagem.tipoQuarto.id == null}"> selected </c:if>></option>
                <c: forEach items="${tipoQuartos}" var="tipoQuarto">
                    <option value="${tipoQuarto.id}" <c:if test="${hospedagem.tipoQuarto.id == tipoQuarto.id}"></option>
                </c:forEach>
                </select>
            </td></tr>
        </table>
        <input type="submit" name="">
        </form>
    </body>
</html>