<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Padrão Frigobar</title>
    </head>
    <body>
        <form action="ManterItemFrigobarController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>id</th>
                    <th>Quantidade</th>
                </tr>
                <c:forEach items="${itensFrigobar}" var="itemFrigobar">
                    <tr>
                        <td>
                            <c:out value="${itemFrigobar.id}" />
                        </td>
                        <td>
                            <c:out value="${itemFrigobar.quantidade}" />
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>
</html>