<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="nav.jsp"/>
<body class="show-all-bg">
<div class="container mx-auto w-50">
    <h1 class="text-center my-5">Sign Up</h1>

    <form:form action="save-user" modelAttribute="users">
        <form:hidden path="id"/>
        <div class="form-group">
            <label>Username</label>
            <form:input path="username" class="form-control" required="required"/>
        </div>
        <div class="form-group">
            <label>Password</label>
            <form:input path="password" class="form-control" required="required"/>
        </div>
        <div class="text-center">
            <input type="submit" class="btn btn-outline-dark w-25 mb-5 mt-3" value="Sign Up"/>
        </div>
    </form:form>
</div>
</body>
