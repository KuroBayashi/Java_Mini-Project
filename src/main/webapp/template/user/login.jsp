<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User:Login</title>
        
        <link rel="stylesheet" type="text/css" href="./css/design.css"> 
    </head>
    <body>
        <%@ include file="../partial/_header.jsp" %>
        
        <div class="s-container-main">
            <jsp:include page="../partial/_flashes.jsp">
                <jsp:param name="flashBag" value="${flashBag}" />
            </jsp:include>
            
            <h2>Login</h2>
            <form method="POST" class="o-wrapper c-form">
                <div class="c-form__row">
                    <label for="username">Username <span class="c-form__label-info">(email)</span></label>
                    <input type="text" name="username" id="username">
                </div>
                <div class="c-form__row">
                    <label for="password">Password <span class="c-form__label-info">(id)</span></label>
                    <input type="password" name="password" id="password">
                </div>

                <input type="hidden" name="_action" value="login">

                <button type="submit" class="c-btn">Login</button>
            </form>
        </div>
        
        <%@ include file="../partial/_footer.jsp" %>
    </body>
</html>