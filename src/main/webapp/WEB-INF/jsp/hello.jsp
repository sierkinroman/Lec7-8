<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="fragments/head.jsp">
        <jsp:param name="pageTitle" value="Hello"/>
    </jsp:include>
</head>
<body class="bg-light">
    <jsp:include page="fragments/menu.jsp">
        <jsp:param name="linkTo" value="users"/>
        <jsp:param name="linkToTitle" value="All users"/>
    </jsp:include>
    <div class="container my-5">
        <h1 class="text-center">Hello, <c:out value="${authUser.firstName}"/></h1>
    </div>

    <jsp:include page="fragments/bootstrapScripts.jsp"/>
</body>
</html>