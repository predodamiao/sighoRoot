<!DOCTYPE html>
<html>
<head>
	<title>Cadastro Item de Consumo </title>
</head>
<body>
        <h1>Cadastrar Item de Consumo    </h1>
    <form>
        <table>
            <tr><td><label for="categoriaItemConsumo">Produto:</label></td><td>
                <select name="categoriaItemConsumo" id="categoriaItemConsumo">
                    <option value="0" <c:if test="${itemFrigobar.item.id == null}"> selected </c:if>></option>
                <c: forEach items="${itens}" var="item">
                    <option value="${itemFrigobar.item}" <c:if test="${itemFrigobar.item.id == itemConsumo.id}"></option>
                </c:forEach>
                </select>
            </td></tr>
            <tr><td><label for="quantidade">Quantidade:</label></td><td><input type="number" name="quantidade" id="quantidade" value="itemFrigobar.quantidade"></td></tr>
        </table>
        <input type="submit" name="">
    </form>
</body>
</html>