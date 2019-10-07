<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Item de Consumo</title>
    </head>
    <body>
        <h1>Item de Consumo - ${operacao}</h1>
        <form>
            <table>

                <tr>
                    <td>
                        <label for="codigo">Código:</label>
                    </td>
                    <td>
                        <input type="text" name="codigo" id="codigo" value="${itemConsumo.codigo}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="nome">Nome:</label>
                    </td>
                    <td>
                        <input type="text" name="nome" id="nome" value="${itemConsumo.nome}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="descricao">Descrição:</label>
                    </td>
                    <td>
                        <textarea name="descricao" id="descricao">${itemConsumo.descricao}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="preco">Preco de Consumo:</label>
                    </td>
                    <td>
                        <input type="number" name="preco" id="preco" step="0.10" min="0.00" value="${itemConsumo.preco}">
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
            </table>
            <input type="submit" name="enviar">
        </form>
    </body>
</html>