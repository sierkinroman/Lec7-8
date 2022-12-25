<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="fragments/head.jsp">
        <jsp:param name="pageTitle" value="Error"/>
    </jsp:include>
</head>
<body class="bg-light">
    <div class="container d-flex align-items-center justify-content-center flex-column" style="height: 100vh">
        <h1><c:out value="${status}"/></h1>
        <h2><c:out value="${error}"/></h2>
        <a href="${pageContext.request.contextPath}/" class="btn btn-primary mt-3">Back to Homepage</a>
    </div>

    <jsp:include page="fragments/bootstrapScripts.jsp"/>
 </body>
</html>