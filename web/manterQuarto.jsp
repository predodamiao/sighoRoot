<!DOCTYPE html>
<html>
<head>
	<title>Cadastro Quarto </title>
</head>
 <body>
        <h1>Cadastrar Quarto    </h1>
       
    <form>
        <table>
            <tr><td><label for="identificacao">Identificação:</label> </td><td><input type="text" name="identificacao" id="identificacao" value="$quarto.identificacao"></td></tr>    
            <tr><td><label for="quantidadeCamasCasal">Quantidade de Camas de Casal:</label> </td><td><input type="number" name="quantidadeCamasCasal" id="quantidadeCamasCasal" min="0" value="$quarto.quantidadeCamasCasal"></td></tr>
            <tr><td><label for="quantidadesCamasSolteiro">Quantidade de Camas de Solteiro:</label> </td><td><input type="number" name="quantidadesCamasSolteiro" id="quantidadesCamasSolteiro" min="0" value="$quarto.quantidadesCamasSolteiro"></td></tr>
            <tr><td><label for="ocupado">Ocupado:</label> </td><td><input type="checkbox" name="ocupado" id="ocupado" value="$quarto.ocupado"></td></tr>
            <tr><td><label for="tipoQuarto">Tipo de Quarto:</label> </td><td>
                <select name="tipoQuarto" id="tipoQuarto">
                    <option value="0" <c:if test="${quarto.tipoQuarto.id == null}"> selected </c:if>></option>
                <c: forEach items="${tipoQuartos}" var="tipoQuarto">
                    <option value="${tipoQuarto.id}" <c:if test="${quarto.tipoQuarto.id == tipoQuarto.id}"></option>
                </c:forEach>
                </select>
            </td></tr>
        </table>
        <input type="submit" name="">
    </form>
    </body>
</html>