<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Users</title>
</head>
<body class="bg-light">
    <jsp:include page="fragments/menu.jsp"/>
    <div class="container my-5">
        <h1 class="text-center">List of users:</h1>
        <table class="table table-striped table-bordered mt-4">
            <thead class="thead-dark">
            <tr>
                <th>#</th>
                <th>Username</th>
                <th>First name</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}" varStatus="i">
                <tr>
                    <td>${i.count}</td>
                    <td><c:out value="${user.username}"/></td>
                    <td><c:out value="${user.firstName}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <jsp:include page="fragments/bootstrapScripts.jsp"/>
</body>
</html>