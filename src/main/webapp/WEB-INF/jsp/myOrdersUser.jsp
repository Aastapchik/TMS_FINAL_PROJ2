<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li><a href="http://localhost:8080" class="nav-link px-2 text-red"
                       style="color: red; font-weight: bold">MYPROJPROFI</a></li>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                        <ul class="dropdown-menu">
                            <c:forEach items="${cities}" var="city">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/profi-welcome-${city}">${city}</a></li>
                            </c:forEach>
                            </option>
                        </ul>
                    </button>

                </div>


                <li><a href="${pageContext.request.contextPath}/profi-welcome" class="nav-link px-2 text-white">Вернуться
                    на главную</a></li>
                <li><p>_______________</p>
                </li>

                    <li><a href="#" class="nav-link px-2 text-white">Вход для специалистов</a></li>
                    <li><a class="nav-link px-2 text-white">Приветствуем, ${username}</a></li>


            <div class="text-end">

                <button class="btn btn-warning" onclick="location.href='/logout'" type="button">
                    Выйти из аккаунта
                </button>
            </div>
            </ul>
    </div>
    </div>
</header>
<br>
<div class="container text-center">
    <div class="row">
        <div class="col" style="font-size: 50px; font-weight: bold">Мои заказы</div>
        <div class="col"></div>
        <div class="col"></div>
    </div>
</div>
<br>
<div class="container text-center">
    <div class="card w-100 mb-3">
        <div class="card-body">
            <h5 class="card-title" style="font-size: 45px">Создать заказ</h5>
            <div class="container text-center">
                <div class="row">
                    <div class="col-10">
                        <form>
                            <p>
                                <input class="form-control" style="width: 1050px"
                                       placeholder="Услуга или специалист"
                                       aria-label="Search">
                            </p>
                        </form>
                    </div>
                    <div class="col-2">
                        <button type="button" class="btn btn-danger">Перейти к созданию</button>
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
                <h5 class="card-title" style="font-size: 45px">Заказ: ${order.nameOrder}</h5>
                <div class="container text-right">
                    <p style="text-align: left; font-size: 25px"> Статус: ${order.status} </p>
                    <c:choose>
                        <c:when test="${order.status != states.get(2)}">
                            <p style="text-align: left; font-size: 25px;">
                                Исполнитель: ${order.master.getUserCard().getName()} ${order.master.getUserCard().getSurname()} </p>
                        </c:when>
                        <c:when test="${order.status == states.get(2)}">
                            <p style="text-align: left; font-size: 25px;"> Ваш заказ пока никто не обработал </p>
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

</body>


</html>