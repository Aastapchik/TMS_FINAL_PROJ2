<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="locale" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
-->
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
                <li><a href="${pageContext.request.contextPath}/profi-master-welcome" class="nav-link px-2 text-red"
                       style="color: red; font-weight: bold">MYPROJPROFI</a></li>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                        Minsk
                    </button>
                    <ul class="dropdown-menu">
                        <c:forEach items="${cities}" var="city">
                            <li><a class="dropdown-item" href="/${city}">${city}</a></li>
                            <br>
                        </c:forEach>
                    </ul>
                </div>
                <c:if test="${statusAcc}">
                    <button class="btn btn-outline-light me-2" onclick="location.href='/profi-master-show-orders'"
                            type="button">
                        <locale:message key="view_current_orders"/>
                    </button>

                    <li><a class="nav-link px-2 text-white"><locale:message key="hello"/>, ${username}</a></li>
                </c:if>
            </ul>


            <div class="text-end">

                <div class="text-end">
                    <a href="<%=request.getContextPath()%>?locale=en">EN</a>
                    <a href="<%=request.getContextPath()%>?locale=ru">RU</a>
                    <c:if test="${statusAcc}">
                        <button class="btn btn-outline-light me-2" onclick="location.href='/profi-master-settings'"
                                type="button">
                            <locale:message key="edit_my_details"/>
                        </button>
                    </c:if>
                    <button class="btn btn-outline-light me-2" onclick="location.href='/logout'" type="button">
                        <locale:message key="logout"/>
                    </button>
                </div>
            </div>
        </div>
</header>
<c:if test="${statusAcc}">
    <br>
    <div class="container text-left">
        <div class="row">
            <div class="col" style="font-size: 50px; font-weight: bold"><locale:message
                    key="orders_I_am_fulfilling"/></div>

        </div>
    </div>

    <c:if test="${masterOrders.size() == 0}">
        <br>
        <div class="container text-center">
            <p style="font-size: 15px; color: #cc6600; font-weight: bold"><locale:message
                    key="there_are_no_such_orders_yet"/></p>
        </div>
    </c:if>
    <c:forEach items="${masterOrders}" var="order" varStatus="i">
        <br>
        <div class="container text-center">
            <div class="card w-100 mb-3">
                <div class="card-body">
                    <h5 class="card-title" style="font-size: 45px"><locale:message
                            key="order"/>: ${order.nameOrder}</h5>
                    <div class="container text-right">

                        <form action="${pageContext.request.contextPath}/profi-master-remove-order" method="post"
                              name="removeOrder" id="removeOrder${order.getId()}">


                            <input name="status" type="hidden" value="${order.status}"/>
                            <input name="description" type="hidden" value="${order.descriptionOrder}"/>
                            <input name="name" type="hidden" value="${order.nameOrder}"/>
                            <p style="text-align: left; font-size: 25px"><locale:message
                                    key="status_master"/>: ${order.status} </p>
                            <hr>
                            <p style="text-align: left; font-size: 15px"><locale:message
                                    key="description_order"/>: ${order.descriptionOrder} </p>
                            <hr>
                            <p style="text-align: left; font-size: 25px;">
                                <locale:message
                                        key="customer"/>: ${order.user.getUserCard().getName()} ${order.user.getUserCard().getSurname()} </p>
                        </form>

                        <c:if test="${flagList.get(i.index)}">
                            <button type="submit" form="removeOrder${order.getId()}" class="btn btn-danger">
                                <locale:message key="cancel_order"/>
                            </button>
                            <br>
                            <form action="${pageContext.request.contextPath}/profi-master-report-completion"
                                  method="post"
                                  name="reportCompletion" id="reportCompletion${order.getId()}">
                                <input name="status" type="hidden" value="${order.status}"/>
                                <input name="description" type="hidden" value="${order.descriptionOrder}"/>
                                <input name="name" type="hidden" value="${order.nameOrder}"/>
                                <br>

                                <label for="answer" class="form-label" style="text-align: left">Ответ (обязательное поле): </label>
                                <input required type="text" class="form-control" name="answer" id="answer">
                                <br>
                                <button type="submit" form="reportCompletion${order.getId()}" class="btn btn-danger">
                                    <locale:message key="report_completion_of_execution"/>
                                </button>
                            </form>
                        </c:if>
                        <c:if test="${!flagList.get(i.index)}">
                            <form action="${pageContext.request.contextPath}/profi-master-show-review"
                                  method="post"
                                  name="reportCompletion" id="addReview${order.getId()}">
                                <input name="idUser" type="hidden" value="${order.getUser().getId()}"/>
                                <br>
                                <button type="submit" form="addReview${order.getId()}" class="btn btn-danger">
                                    <locale:message key="leave_feedback_about_the_customer"/>
                                </button>
                            </form>
                        </c:if>


                    </div>
                </div>
            </div>
        </div>

    </c:forEach>
</c:if>

<c:if test="${!statusAcc}">
    <div class="container text-center">
        <div class="row">
            <div class="col-10"><p style="font-weight: bold; color: gray; font-size: 75px; text-align: center">
                Аккаунт заблокирован. Причина: ${reason}</p></div>
            <div class="col-2"></div>
        </div>
    </div>

</c:if>
</body>


</html>