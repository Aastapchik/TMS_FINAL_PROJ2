<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Настройка задач</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title></title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

  <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,600,700&subset=latin,cyrillic" rel="stylesheet"
        type="text/css">
  <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"
        type="text/css">
  <style>


    *,
    *:before,
    *:after {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    html,
    body {
      height: 100%;
    }

    body {
      font: 14px/1 "Open Sans", sans-serif;
      color: #555;
      background: #fafafa;
    }

    /* фиксированное верхнее меню*/

    .top-nav {
      background: #555555;
      box-shadow: 0 2px 6px 0 rgba(0, 0, 0, 0.4);
      left: 0;
      opacity: 0.95;
      padding: 8px;
      position: fixed;
      right: 0;
      top: 0;
      z-index: 9999;
    }

    .topnav-wrapper {
      margin: 0 auto;
      max-width: 980px;
    }

    .top-logo {
      color: #ddd;
      font: bold 16px/20px "Crete Round", serif;
      padding-left: 10px;
      text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.5);
    }

    .top-logo a {
      color: #B8B8B8;
      text-decoration: none;
    }

    .top-logo a:hover {
      color: #ddd;
    }

    .topnav-right {
      float: right;
    }

    .right-menu {
      margin: 0;
      overflow: hidden;
    }

    .right-menu li {
      float: left;
      list-style-type: none;
      margin: 0;
    }

    .right-menu li a {
      color: #B8B8B8;
      display: block;
      padding: 0.05em 0.75em;
      text-decoration: none;
      text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.3);
    }

    .right-menu li a:hover {
      color: #fff;
      text-shadow: none;
    }

    .right-menu li span {
      font-size: 16px;
      line-height: 1.2;
    }


    h1 {
      padding: 50px 0;
      font-weight: 400;
      text-align: center;
    }

    .info {
      color: rgba(78, 78, 78, 0.8);
      width: 100%;
      margin: 40px auto;
      text-align: center;
      font-weight: 300;
    }

    .info a {
      color: #bbb;
      text-decoration: none;
    }

    .info a:hover {
      color: #888;
    }

    /* Конец стилей демо-страницы */
    /* Базовый контейнер табов */

    .tabs {
      min-width: 500px;
      max-width: 800px;
      padding: 2px;
      margin: 0 auto;
    }

    /* Стили секций с содержанием */

    .tabs > section {
      display: none;
      padding: 15px;
      background: #fff;
      border: 1px solid #ddd;
    }

    .tabs > section > p {
      margin: 0 0 20px;
      line-height: 1.5;
      color: #383838;
      /* прикрутим анимацию */
      -webkit-animation-duration: 1s;
      animation-duration: 1s;
      -webkit-animation-fill-mode: both;
      animation-fill-mode: both;
      -webkit-animation-name: fadeIn;
      animation-name: fadeIn;
    }

    /* Описываем анимацию свойства opacity */

    @-webkit-keyframes fadeIn {
      from {
        opacity: 0;
      }
      to {
        opacity: 1;
      }
    }

    @keyframes fadeIn {
      from {
        opacity: 0;
      }
      to {
        opacity: 1;
      }
    }

    /* Прячем чекбоксы */

    .tabs > input {
      display: none;
      position: absolute;
    }

    /* Стили переключателей вкладок (табов) */

    .tabs > label {
      display: inline-block;
      margin: 0 0 -1px;
      padding: 15px 25px;
      font-weight: 600;
      text-align: center;
      color: #aaa;
      border: 0px solid #ddd;
      border-width: 1px 1px 1px 1px;
      background: #f1f1f1;
      border-radius: 3px 3px 0 0;
    }

    /* Шрифт-иконки от Font Awesome в формате Unicode */

    .tabs > label:before {
      font-family: fontawesome;
      font-weight: normal;
      margin-right: 10px;
    }

    .tabs > label[for*="1"]:before {
      content: "\f19a";
    }

    .tabs > label[for*="2"]:before {
      content: "\f17a";
    }

    .tabs > label[for*="3"]:before {
      content: "\f13b";
    }

    .tabs > label[for*="4"]:before {
      content: "\f13c";
    }

    /* Изменения стиля переключателей вкладок при наведении */

    .tabs > label:hover {
      color: #888;
      cursor: pointer;
    }

    /* Стили для активной вкладки */

    .tabs > input:checked + label {
      color: #555;
      border-top: 1px solid #009933;
      border-bottom: 1px solid #fff;
      background: #fff;
    }

    /* Активация секций с помощью псевдокласса :checked */

    #tab1:checked ~ #content-tab1,
    #tab2:checked ~ #content-tab2,
    #tab3:checked ~ #content-tab3,
    #tab4:checked ~ #content-tab4 {
      display: block;
    }

    /* Убираем текст с переключателей
* и оставляем иконки на малых экранах
*/

    @media screen and (max-width: 680px) {
      .tabs > label {
        font-size: 0;
      }

      .tabs > label:before {
        margin: 0;
        font-size: 18px;
      }
    }

    /* Изменяем внутренние отступы
*  переключателей для малых экранов
*/

    @media screen and (max-width: 400px) {
      .tabs > label {
        padding: 15px;
      }
    }


    /*ЗВЕЗДОЧКИ-ОЦЕНКИ*/

    .rating-area {
      overflow: hidden;
      width: 265px;
      margin: 0 auto;
    }

    .rating-area:not(:checked) > input {
      display: none;
    }

    .rating-area:not(:checked) > label {
      float: right;
      width: 42px;
      padding: 0;
      cursor: pointer;
      font-size: 32px;
      line-height: 32px;
      color: lightgrey;
      text-shadow: 1px 1px #bbb;
    }

    .rating-area:not(:checked) > label:before {
      content: '★';
    }

    .rating-area > input:checked ~ label {
      color: gold;
      text-shadow: 1px 1px #c60;
    }

    .rating-area:not(:checked) > label:hover,
    .rating-area:not(:checked) > label:hover ~ label {
      color: gold;
    }

    .rating-area > input:checked + label:hover,
    .rating-area > input:checked + label:hover ~ label,
    .rating-area > input:checked ~ label:hover,
    .rating-area > input:checked ~ label:hover ~ label,
    .rating-area > label:hover ~ input:checked ~ label {
      color: gold;
      text-shadow: 1px 1px goldenrod;
    }

    .rate-area > label:active {
      position: relative;
    }

    .rating-result {
      width: 265px;
      margin: 0 auto;
    }

    .rating-result span {
      padding: 0;
      font-size: 32px;
      margin: 0 3px;
      line-height: 1;
      color: lightgrey;
      text-shadow: 1px 1px #bbb;
    }

    .rating-result > span:before {
      content: '★';
    }

    .rating-result > span.active {
      color: gold;
      text-shadow: 1px 1px #c60;
    }

    .rating-mini {
      display: inline-block;
      font-size: 0;
    }

    .rating-mini span {
      padding: 0;
      font-size: 20px;
      line-height: 1;
      color: lightgrey;
    }

    .rating-mini > span:before {
      content: '★';
    }

    .rating-mini > span.active {
      color: gold;
    }


  </style>
</head>

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


        <li><a href="${pageContext.request.contextPath}/profi-user-welcome" class="nav-link px-2 text-white">Вернуться
          на главную</a></li>
        <li><p>__________________</p></li>

        <li><a class="nav-link px-2 text-white">Приветствуем, ${username}</a></li>
      </ul>

      <div class="text-end">
        <button class="btn btn-warning" onclick="location.href='/profi-master-login'" type="button">
          Вход для специалистов
        </button>

        <button class="btn btn-warning" onclick="location.href='/logout'" type="button">
          Выйти из аккаунта
        </button>
      </div>
    </div>
  </div>
</header>
<br>
<div class="container">

  <div class="tabs">
    <input id="tab1" type="radio" name="tabs" checked>
    <label for="tab1" title="Моя учетная запись">Посмотреть мою учетную запись</label>
    <input id="tab2" type="radio" name="tabs">
    <label for="tab2" title="Редактирование учетной записи">Редактировать мои данные</label>
    <input id="tab3" type="radio" name="tabs">
    <label for="tab3" title="Отзывы">Отзывы клиентов</label>

    <section id="content-tab1">

      <div class="rating-result">
        <p style="font-size: 25px">Мой рейтинг:</p>
        <c:forEach begin="1" end="${score}">
          <span class="active"></span>
        </c:forEach>
        <c:forEach begin="1" end="${5-score}">
          <span></span>
        </c:forEach>
        ${scoreNoRound}
      </div>
      <p style="font-size: 25px">Моё имя: ${userCard.name}</p>
      <p style="font-size: 25px">Моя фамилия: ${userCard.surname}</p>
      <p style="font-size: 25px">Сферы деятельности: </p>
      <p style="font-size: 25px">Краткое резюме: ${userCard.description}</p>

    </section>

    <section id="content-tab2">
      <p style="text-align: center; font-size: 25px">Заполните те графы, которые желаете изменить.</p>
      <form method="post" action="${pageContext.request.contextPath}/profi-user-update-card" name="updateCardUser"
            id="updateCardUser">
        <br>
        <label style="color: #cc6600; font-size: 15px; font-style: italic">Изменить имя</label>
        <br>
        <input class="form-control" name="newNameUser" style="width: 750px"
               placeholder="Введите имя"/>
        <br>
        <label style="color: #cc6600; font-size: 15px; font-style: italic">Изменить фамилию</label>
        <br>
        <input class="form-control" name="newSurnameUser" style="width: 750px"
               placeholder="Введите фамилию"/>
        <br>
        <label style="color: #cc6600; font-size: 15px; font-style: italic">Обновить сферы деятельности</label>
        <br>
        <input class="form-control" name="newSpheresActivityUser" style="width: 750px"
               placeholder="Указанные сферы деятельности:}"/>
        <br>
        <label style="color: #cc6600; font-size: 15px; font-style: italic">Обновить резюме</label>
        <br>
        <input class="form-control" name="newDescriptionUser" style="width: 750px"
               placeholder=""/>
        <br>
        <button type="submit" class="btn btn-danger" form="updateCardUser" style="text-align: right">Обновить
          данные
        </button>
      </form>

    </section>

    <section id="content-tab3">
      <c:if test="${userReviewsList.size() > 0}">
        <c:forEach var="i" begin="0" end="${userReviewsList.size()/2}" step="2">
          <div class="container text-center">
            <div class="row">
              <div class="col">
                <div class="rating-mini">
                  <c:forEach begin="1" end="${userReviewsList.get(i).getGrade()}">
                    <span class="active"></span>
                  </c:forEach>
                  <c:forEach begin="1" end="${5-userReviewsList.get(i).getGrade()}">
                    <span></span>
                  </c:forEach>
                </div>
                <p>Отзыв: ${userReviewsList.get(i).getReview()}</p>
              </div>
              <c:if test="${userReviewsList.get(i+1).getGrade() != 6}">
                <div class="col">

                  <div class="rating-mini">
                    <c:forEach begin="1" end="${userReviewsList.get(i+1).getGrade()}">
                      <span class="active"></span>
                    </c:forEach>
                    <c:forEach begin="1" end="${5-userReviewsList.get(i+1).getGrade()}">
                      <span></span>
                    </c:forEach>
                  </div>
                  <p>Отзыв: ${userReviewsList.get(i+1).getReview()}</p>
                </div>
              </c:if>
              <c:if test="${userReviewsList.size() == 0}"><p>У тебя пока еще нет отзывов :)</p></c:if>
            </div>

          </div>
          <hr>
        </c:forEach>
      </c:if>
    </section>

  </div>
</div>
</body>