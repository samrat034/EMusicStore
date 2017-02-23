<%--
  Created by IntelliJ IDEA.
  User: samrat
  Date: 1/7/17
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator Page</h1>
            <p class="lead">This is the administrator page</p>
        </div>
        <c:if test="${pageContext.request.userPrincipal.name !=null}">
            <h2>
                Welcome:${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout"/>">Logout</a>
            </h2>
        </c:if>

        <h3>
            <a href="<c:url value="/admin/productInventory" />">Product Inventory</a>
        </h3>
        <p>Here you can view, modify and check the product inventory</p>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>



