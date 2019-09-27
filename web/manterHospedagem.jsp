<!DOCTYPE html>
<html>
<head>
	<title>Cadastro Hospedagem</title>
</head>

    <body>
        <h1>Cadastrar Hospedagem</h1>
        <form>    
        <table>
            <tr><td><label for="chegada">Chegada:</label> </td><td><input type="datetime-local" name="dataChegada" id="dataChegada"></td></tr>
            <tr><td><label for="saida">Saída:</label> </td><td><input type="datetime-local" name="dataSaida" id="dataSaida"></td></tr>
            <tr><td><label for="tipoQuarto">Tipo de Quarto:</label> </td><td>
                <select>
                    <option></option>
                </select>
            </td></tr>
            <tr><td><label for="quarto">Quarto:</label> </td><td>
                <select>
                    <option></option>
                </select>
            </td></tr>
            <tr><td><label for="pagamento">Forma Pagamento:</label> </td><td>
                <select>
                    <option></option>
                </select>
            </td></tr>
            <tr><td><label for="checkin">Check-in:</label> </td><td><input type="checkbox" name="checkin" id="checkin"></td></tr>  
        </table>
        <input type="submit" name="">
        </form>
    </body>
</html>