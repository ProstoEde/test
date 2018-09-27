<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<style type="text/css">
    .tg {
        border-collapse: collapse;
        border-spacing: 0;
        border-color: #cccccc;
    }
    .tg td{
        font-family: Arial, sans-serif;
        font-size: 14px;
        padding: 10px 5px;
        border-style: solid;
        border-width: 1px;
        overflow: hidden;
        word-break: normal;
        border-color: #cccccc;
        color: #333333;
        background-color: #ffffff;
    }
    .tg th {
        font-family: Arial, sans-serif;
        font-size: 14px;
        font-weight: normal;
        padding: 10px 5px;
        border-style: solid;
        border-width: 1px;
        overflow: hidden;
        word-break: normal;
        border-color: #cccccc;
        color: #333333;
        background-color: #ffffff;
    }
</style>
<head>
    <title>Список</title>
</head>
<body>
<h1>Список данных БД</h1>

<form>
    <input type="button" value="Добавить" onclick="javascript:window.location='add'"/>
    <input type="button" value="Главная страница" onclick="javascript:window.location='start'"/>
    <input type="button" value="Просмотр" onclick="javascript:window.location='list'"/>
</form>

<form method="post"  modelAttribute="userJSP" action="sort">
    Поиск по:
    <br/>
    ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="id" value="">

    <br/>
    NAME<input type = "text"  name = "name" value =  "">

    <input type="submit" value="Поиск">
</form>
<br/>

<table class="tg">
    <tr>
        <th width="30">ID</th>
        <th width="120">NAME</th>
    </tr>
    <c:forEach items="${userJSP}" var="per">
        <tr>
            <td>${per.id}</td>
            <td>${per.name}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>