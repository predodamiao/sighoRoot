<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Quartos</title>
    </head>
    <body>
        <form action="ManterQuartoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th>Identificacao</th>
                    <th>Ocupado</th>
                    <th>id Tipo</th>
                </tr>
                <c:forEach items="${quartos}" var="quarto">
                    <tr>
                        <td>
                            <c:out value="${quarto.identificacao}" />
                        </td>
                        <td>
                            <c:out value="${quarto.ocupado}" />
                        </td>
                        <td>
                            <c:out value="${quarto.idTipoQuarto}" />
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="btnIncluir" value="Incluir" />
        </form>
    </body>

</html>