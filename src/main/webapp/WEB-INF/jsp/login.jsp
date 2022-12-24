<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Login</title>
</head>
<body class="bg-light">
    <div class="container d-flex align-items-center justify-content-center" style="height: 100vh">
        <form action="${pageContext.request.contextPath}/login" method="POST" class="mx-auto col-5 border p-5">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" name="username" id="username" class="form-control" autofocus="autofocus"/>
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" class="form-control"/>
            </div>

            <c:if test="${isBadCredentials}">
                <p class="text-danger">Bad username or password</p>
            </c:if>

            <div class="row justify-content-center">
                <button type="submit" class="btn btn-primary px-4">Login</button>
            </div>
        </form>
    </div>

    <jsp:include page="fragments/bootstrapScripts.jsp"/>
</body>
</html>