<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Error</title>
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