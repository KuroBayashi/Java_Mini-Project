<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User:Home</title>
        
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
                <h2>Products</h2>
                
                <div class="o-grid o-grid-gap--s">
                    <c:forEach var="product" items="${products}">
                        <div class="o-grid__cols--4 c-card">
                            <header class="o-wrapper-inside c-card__header">
                                <h3>${product.description}</h3>
                            </header>
                            <div class="c-card__content">
                                <ul>
                                    <li>Purchase cost : ${product.purchaseCost}</li>
                                    <li>Markup : ${product.markup}</li>
                                    <li>Quantity on hand : ${product.quantity}</li>
                                </ul>
                            </div>
                            <footer class="o-wrapper-inside c-card__footer">
                                <form method="POST">
                                    <input type="hidden" name="_action" value="show">
                                    <input type="hidden" name="product_id" value="${product.id}">

                                    <button type="submit" class="c-btn">View more</button>
                                </form>
                            </footer>
                        </div>
                    </c:forEach>
                </div>
            </section>
        </div>
        
        <%@ include file="../partial/_footer.jsp" %>
    </body>
</html>
