<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                    pokzepof kpozkef pokzep okpozekf pozke f
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
                        <input type="hidden" name="_action" value="edit_purchase_order">
                        <input type="hidden" name="num" value="${purchaseOrder.num}">

                        <button type="submit" class="c-btn">Edit</button>
                    </form>
                    <form method="POST" class="u-display--inline c-form">
                        <input type="hidden" name="_action" value="delete_purchase_order">
                        <input type="hidden" name="num" value="${purchaseOrder.num}">

                        <button type="submit" class="c-btn c-btn--danger">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>