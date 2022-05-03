<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"/>

<nav class="navbar navbar-expand-md bg-dark navbar-dark px-5 m-3">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Food Recipes</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <sec:authorize access="!isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link btn btn-primary active" href="sign-up">Sign Up</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login">Login</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="show-all">Show All Recipes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="add-recipe">Add Recipe</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
            </sec:authorize>

        </ul>
    </div>
</nav>