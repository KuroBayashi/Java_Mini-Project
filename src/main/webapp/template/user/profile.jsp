<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User:Profile</title>
        
        <link rel="stylesheet" type="text/css" href="./css/design.css"> 
    </head>
    <body>
        <%@ include file="../partial/_header.jsp" %>
        
        <div class="s-container-main">
            <jsp:include page="../partial/_flashes.jsp">
                <jsp:param name="flashBag" value="${flashBag}" />
            </jsp:include>
            
            <div class="o-grid">
                <section class="o-grid__cols-1-4">
                    <h2>Edit Profile</h2>
                    <jsp:include page="_edit_profile.jsp">
                        <jsp:param name="user" value="${user}" />
                    </jsp:include>
                </section>
                
                <section class="o-grid__cols-4-12">
                    <h2>Edit Purchase Order</h2>
                    <jsp:include page="_edit_purchase_order.jsp">
                        <jsp:param name="purchaseOrders" value="${purchaseOrders}" />
                    </jsp:include>
                </section>
            </div>
            
            <h2>Logout</h2>
            <%@ include file="_logout.jsp" %>
        </div>
        
        <%@ include file="../partial/_footer.jsp" %>
    </body>
</html>
