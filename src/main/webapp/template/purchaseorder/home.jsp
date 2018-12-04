<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PurchaseOrder:Home</title>
        
        <link rel="stylesheet" type="text/css" href="${ctx}/css/design.css"> 
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
                <h2>Edit Profile</h2>
                <jsp:include page="_edit.jsp">
                    <jsp:param name="purchaseOrders" value="${purchaseOrders}" />
                </jsp:include>
            </section>
            
            <h2>Logout</h2>
            <jsp:include page="../auth/_logout.jsp">
                <jsp:param name="logout_path" value="${ctx}" />
            </jsp:include>
        </div>
        
        <%@ include file="../partial/_footer.jsp" %>
    </body>
</html>
