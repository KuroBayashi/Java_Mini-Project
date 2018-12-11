<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PurchaseOrder:Home</title>
        
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
            
            <section class="o-grid__cols-1-4">
                <h2>Edit Purchase Orders</h2>
                
                <table class="o-wrapper c-table c-table--expend">
                    <thead>
                        <tr>
                            <th class="c-table__th">Product</th>
                            <th class="c-table__th">Quantity</th>
                            <th class="c-table__th">Shipping Date</th>
                            <th class="c-table__th">Options</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="purchaseOrder" items="${purchaseOrders}">
                            <tr>
                                <td class="c-table__td">
                                    ${purchaseOrder.product.description}
                                </td>
                                <td class="c-table__td">
                                    <input type="number" name="quantity" form="form_edit_${purchaseOrder.num}" value="${purchaseOrder.quantity}" min="1">
                                </td>
                                <td class="c-table__td">
                                    <input type="date" name="shipping_date" form="form_edit_${purchaseOrder.num}" value="${purchaseOrder.shippingDate}">
                                </td>
                                <td class="c-table__td">
                                    <form method="POST" id="form_edit_${purchaseOrder.num}" class="u-display--inline c-form">
                                        <input type="hidden" name="_action" value="edit">
                                        <input type="hidden" name="order_num" value="${purchaseOrder.num}">

                                        <button type="submit" class="c-btn">Edit</button>
                                    </form>
                                    <form method="POST" class="u-display--inline c-form">
                                        <input type="hidden" name="_action" value="delete">
                                        <input type="hidden" name="order_num" value="${purchaseOrder.num}">

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
