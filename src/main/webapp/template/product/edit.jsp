<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product:Edit</title>
        
        <link rel="stylesheet" type="text/css" href="./css/style.css"> 
    </head>
    <body>
        <jsp:include page="../partial/_header.jsp">
            <jsp:param name="home_path" value="${ctx}/customer" />
        </jsp:include>
        
        <div class="s-container-main">
            <jsp:include page="../partial/_flashes.jsp">
                <jsp:param name="flashBag" value="${flashBag}" />
            </jsp:include>
            
            <section>
                <h2>Edit Products</h2>
                
                <table class="o-wrapper c-table c-table--expend">
                    <thead>
                        <tr>
                            <th class="c-table__th">Description</th>
                            <th class="c-table__th">Code</th>
                            <th class="c-table__th">Manufacturer</th>
                            <th class="c-table__th">Quantity</th>
                            <th class="c-table__th">Purchase cost</th>
                            <th class="c-table__th">Markup</th>
                            <th class="c-table__th">Available</th>
                            <th class="c-table__th">Options</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${products}">
                            <tr>
                                <td class="c-table__td">
                                    <input type="text" name="description" value="${product.description}">
                                </td>
                                <td class="c-table__td">
                                    <select name="code">
                                        <c:forEach var="productCode" items="${productCodes}">
                                            <option value="${product_code.code}" <c:if test="${product_code.code == product.productCode.code}">selected="selected"</c:if> >
                                                ${product_code.description}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td class="c-table__td">
                                    <select name="manufacturer_id">
                                        <c:forEach var="manufacturer" items="${manufacturers}">
                                            <option value="${manufacturer.id}" <c:if test="${manufacturer.id == product.manufacturer.id}">selected="selected"</c:if> >
                                                ${manufacturer.name}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td class="c-table__td">
                                    <input type="number" name="quantity_on_hand" value="${product.quantityOnHand}" min="0">
                                </td>
                                <td class="c-table__td">
                                    <input type="number" name="purchase_cost" value="${product.purchaseCost}" step="0.01">
                                </td>
                                <td class="c-table__td">
                                    <input type="number" name="markup" value="${product.markup}">
                                </td>
                                <td class="c-table__td">
                                    <input type="checkbox" name="available" value="available">
                                </td>
                                <td class="c-table__td">
                                    <form method="POST" id="form_edit_${product.id}" class="u-display--inline c-form">
                                        <input type="hidden" name="_action" value="edit">
                                        <input type="hidden" name="product_id" value="${product.id}">

                                        <button type="submit" class="c-btn">Edit</button>
                                    </form>
                                    <form method="POST" class="u-display--inline c-form">
                                        <input type="hidden" name="_action" value="delete">
                                        <input type="hidden" name="product_id" value="${product.id}">

                                        <button type="submit" class="c-btn c-btn--danger">Delete</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section>
        </div>
        
        <%@ include file="../partial/_footer.jsp" %>
    </body>
</html>
