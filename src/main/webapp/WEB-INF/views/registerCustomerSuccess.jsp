<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<div class="container">
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Customer Register Successfully</h1>
            </div>

        </div>
    </section>
    <section class="container" >
        <p>
            <a href="<spring:url value="/product/productList" />" class="btn btn-default">Products</a>
        </p>

    </section>
 </div>


<script src="<c:url value="/resources/js/controller.js"/> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp" %>