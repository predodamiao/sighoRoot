<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Item Frigobar</title>
    </head>
    <body>
        <h1>Item Frigobar - ${operacao}</h1>
        <form>
            <table>

                <tr>
                    <td>
                        <label for="id">ID:</label>
                    </td>
                    <td>
                        <input type="number" name="id" id="id" value="${itemFrigobar.id}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="categoriaItemConsumo">Categoria do Item de Consumo:</label>
                    </td>
                    <td>
                        <select name="categoriaItemConsumo" id="categoriaItemConsumo">
                            <option value="0" <c:if test="${ItemConsumo.categoria.id == null}"> selected </c:if>></option>
                            <c:forEach items="${categorias}" var="categoria">
                                <option value="${categoria.id}" <c:if test="${ItemConsumo.categoria.id == categoria.id}">selected</c:if>>${categoria.nomeCategoria}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="quantidade">Quantidade:</label>
                    </td>
                    <td>
                        <input type="number" name="quantidade" id="quantidade" value="${itemFrigobar.quantidade}">
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar">
        </form>
    </body>
</html>