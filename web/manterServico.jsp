<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Serviço</title>
    </head>
    <body>
        <h1>Serviço - ${operacao}</h1>
        <form action="ManterServicoController?acao=confirmarOperacao&operacao=${operacao}" method="post">
            <table>
                <tr>
                    <td>
                        <label for="codigo">Código:</label>
                    </td>
                    <td>
                        <input type="text" name="codigo" id="codigo" value="${servico.codigo}"<c:if test="${operacao != 'Incluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="nome">Nome:</label>
                    </td>
                    <td>
                        <input type="text" name="nome" id="nome" value="${servico.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="descricao">Descrição:</label>
                    </td>
                    <td>
                        <textarea name="descricao" id="descricao" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>${servico.descricao}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="preco">Preco de Consumo:</label>
                    </td>
                    <td>
                        <input type="number" name="preco" id="preco" step="0.01" min="0.00" value="${servico.preco}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="categoriaItemConsumo">Categoria do Item de Consumo:</label>
                    </td>
                    <td>
                        <select name="categoriaItemConsumo" id="categoriaItemConsumo" <c:if test="${operacao == 'Excluir'}"> disabled </c:if>>
                            <option value="0" <c:if test="${servico.categoria.id == null}"> selected </c:if>></option>
                            <c:forEach items="${categorias}" var="categoria">
                                <option value="${categoria.nomeCategoria}" <c:if test="${servico.categoria.id == categoria.id}">selected</c:if>>${categoria.nomeCategoria}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" name="enviar" value="${operacao}">
        </form>
    </body>
</html>