<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="locale" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>

<header>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>StartProfi</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</header>


<body>


<svg xmlns="http://www.w3.org/2000/svg" class="d-none">
    <symbol id="check2" viewBox="0 0 16 16">
        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
    </symbol>
    <symbol id="circle-half" viewBox="0 0 16 16">
        <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z"/>
    </symbol>
    <symbol id="moon-stars-fill" viewBox="0 0 16 16">
        <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"/>
        <path d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z"/>
    </symbol>
    <symbol id="sun-fill" viewBox="0 0 16 16">
        <path d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"/>
    </symbol>
</svg>

<div class="b-example-divider"></div>

<header class="p-3 text-bg-dark">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                    <use xlink:href="#bootstrap"/>
                </svg>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="${pageContext.request.contextPath}/profi-user-welcome" class="nav-link px-2 text-red"
                       style="color: red; font-weight: bold">MYPROJPROFI</a></li>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                        <ul class="dropdown-menu">
                            <c:forEach items="${cities}" var="city">
                                <li><a class="dropdown-item"
                                       href="${pageContext.request.contextPath}/profi-welcome-${city}">${city}</a></li>
                            </c:forEach>
                            </option>
                        </ul>
                    </button>

                </div>

<%--                <c:if test="${statusAcc}">--%>
                    <li><a href="${pageContext.request.contextPath}/profi-user-myorders"
                           class="nav-link px-2 text-white"><locale:message key="my_order"/></a></li>

                    <li><a class="nav-link px-2 text-white"><locale:message key="hello"/>, ${username}</a></li>
<%--                </c:if>--%>
            </ul>

            <div class="text-end">
                <a href="<%=request.getContextPath()%>?locale=en">EN</a>
                <a href="<%=request.getContextPath()%>?locale=ru">RU</a>
<%--                <c:if test="${statusAcc}">--%>
                    <button class="btn btn-outline-light me-2" onclick="location.href='/profi-user-settings'"
                            type="button">
                        <locale:message key="edit_account"/>
                    </button>
<%--                </c:if>--%>
                <button class="btn btn-warning" onclick="location.href='/logout'" type="button">
                    <locale:message key="logout"/>
                </button>
<%--                <c:if test="${statusAcc}">--%>
                    <button class="btn btn-warning" onclick="location.href='/profi-master-login'" type="button">
                        <locale:message key="enter_master"/>
                    </button>
<%--                </c:if>--%>

            </div>
        </div>
    </div>
</header>
<br>
<div class="container text-center">
    <div class="row">
        <div class="col" style="font-size: 50px; font-weight: bold"><locale:message key="my_order"/></div>
        <div class="col"></div>
        <div class="col"></div>
    </div>
</div>
<br>
<div class="container text-center">
    <div class="card w-100 mb-3">
        <div class="card-body">
            <h5 class="card-title" style="font-size: 45px"><locale:message key="create_order"/></h5>
            <div class="container text-center">
                <div class="row">
                    <div class="col-10">
                        <form method="post" action="${pageContext.request.contextPath}/profi-user-create-order"
                              name="createOrder" id="createOrder">
                            <p>
                                <input class="form-control" style="width: 1050px"
                                       placeholder="<locale:message key="service_or_specialist"/>"
                                       aria-label="Search" name="orderWhichUserWant">
                            </p>
                        </form>
                    </div>
                    <div class="col-2">
                        <button type="submit" class="btn btn-danger" form="createOrder"><locale:message key="go_to_creation"/></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<c:forEach items="${orders}" var="order">
    <br>
    <div class="container text-center">
        <div class="card w-100 mb-3">
            <div class="card-body">
                <h5 class="card-title" style="font-size: 45px"><locale:message key="order"/>: ${order.nameOrder}</h5>

                <form name="delete" id="delete${order.getId()}" method="post"
                      action="${pageContext.request.contextPath}/profi-user-delete-order">

                    <div class="container text-right">
                        <input name="status" type="hidden" value="${order.status}"/>
                        <input name="description" type="hidden" value="${order.descriptionOrder}"/>
                        <input name="name" type="hidden" value="${order.nameOrder}"/>
                        <p style="text-align: left; font-size: 25px"> <locale:message key="status_master"/>: ${order.status} </p>
                        <hr>
                        <p style="text-align: left; font-size: 15px"> <locale:message key="description_order"/>: ${order.descriptionOrder} </p>
                        <hr>
                            <%--                        <c:choose>--%>
                        <c:if test="${order.status == states.get(1)}">
                            <p style="text-align: left; font-size: 25px;">
                                <locale:message key="executor"/>: ${order.master.getUserCard().getName()} ${order.master.getUserCard().getSurname()} </p>

                        </c:if>
                            <%--                        </c:choose>--%>
                    </div>
                    <div class="container text-right">
                            <%--                        <c:choose>--%>
                        <c:if test="${order.status == states.get(2)}">
                            <p style="text-align: left; font-size: 25px;"> <locale:message key="no_one_has_processed_your_order_yet"/> </p>
                            <button type="submit" class="btn btn-danger" form="delete${order.getId()}"
                                    style="text-align: right"><locale:message key="delete_order"/>
                            </button>
                        </c:if>
                    </div>
                </form>
                <c:if test="${order.status == states.get(3)}">
                    <form action="${pageContext.request.contextPath}/profi-user-show-review"
                          method="post"
                          name="reportCompletion" id="addReview${order.getId()}">
                        <p style="text-align: left; font-size: 25px;">Ответ: ${order.getAnswer()}</p>
                        <input name="idUser" type="hidden" value="${order.getMaster().getId()}"/>
                        <br>
                        <button type="submit" form="addReview${order.getId()}" class="btn btn-danger">
                            <locale:message key="leave_a_review_about_the_master"/>
                        </button>
                    </form>
                </c:if>
                    <%--                </c:choose>--%>
            </div>
        </div>
    </div>

</c:forEach>

</body>


</html>