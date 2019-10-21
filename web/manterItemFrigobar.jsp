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
        <form action="ManterItemFrigobarController?acao=confirmarOperacao&operacao=${operacao}" method="post">
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
                        <label for="itemConsumo">Produto:</label>
                    </td>
                    <td>
                        <select name="itemConsumo" id="itemConsumo">
                            <option value="0" <c:if test="${itemFrigobar.id == null}"> selected </c:if>></option>
                            <c:forEach items="${itens}" var="item">
                                <option value="${item.codigo}" <c:if test="${item.codigo == itemFrigobar.item.codigo}">selected</c:if>>${item.nome}</option>
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