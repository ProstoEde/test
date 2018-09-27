<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Добавление в БД</title>
</head>
<body>
<h1>Страница добавления в БД</h1>
<form method="post"  modelAttribute="userJSP" action="check">
    Введите имя:
    <input type = "text"  name = "name">
    <input type="submit" value="Добавить">
</form>
<br/>
<form>
    <input type="button" value="Главная страница" onclick="javascript:window.location='start'"/>
</form>
</body>
</html>