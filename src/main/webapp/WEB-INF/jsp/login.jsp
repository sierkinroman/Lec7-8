<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="fragments/head.jsp">
        <jsp:param name="pageTitle" value="Login"/>
    </jsp:include>
</head>
<body class="bg-white">
    <div class="container d-flex align-items-center justify-content-center" style="height: 100vh">
        <form action="${pageContext.request.contextPath}/login" method="POST" class="mx-auto col-5 border p-5 bg-light">
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