<ul class="nav justify-content-end py-2 bg-secondary">
    <li class="nav-item">
        <a href="${pageContext.request.contextPath}/${param.linkTo}" class="nav-link text-light">${param.linkToTitle}</a>
    </li>
    <li class="nav-item mr-5">
        <form action="${pageContext.request.contextPath}/logout" method="POST" class="nav-item">
            <input type="submit" value="Logout" class="btn btn-link nav-link text-light"/>
        </form>
    </li>
</ul>