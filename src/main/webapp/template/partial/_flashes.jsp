<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="o-wrapper--w-full">
    <c:forEach var="flashType" items="${flashBag.getAll()}">
        <c:forEach var="message" items="${flashType.value}">
            <div class="c-flash c-flash--${flashType.key}">
                ${message}
            </div>
        </c:forEach>
    </c:forEach>
</div>