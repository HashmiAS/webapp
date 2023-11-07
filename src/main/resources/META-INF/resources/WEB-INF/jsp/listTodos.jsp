<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min-jsf.css" rel="stylesheet">
    <title>Todos page</title>
</head>
    <body>
        <div class="container">
            <h1>Your Todos are:</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>description</th>
                        <th>target_date</th>
                        <th>status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.id}</td>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.status}</td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">Add To-do</a>
        </div>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>

