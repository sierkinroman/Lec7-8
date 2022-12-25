<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="fragments/head.jsp">
        <jsp:param name="pageTitle" value="Users"/>
    </jsp:include>
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