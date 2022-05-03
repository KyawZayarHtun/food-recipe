<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="nav.jsp"/>
<body class="add-bg">
<div class="container mx-auto w-50">
    <h1 class="text-center my-5">Add Recipe</h1>
    <form:form action="save-recipe" modelAttribute="recipes">
        <form:hidden path="username"/>
        <form:hidden path="id"/>
        <div class="form-group">
            <label>Title</label>
            <form:input path="title" class="form-control" required="required"/>
        </div>
        <div class="form-group">
            <label>Description</label>
            <form:textarea path="description" class="form-control" required="required"/>
        </div>
        <div class="form-group">
            <label>Ingredients</label>
            <form:textarea path="ingredients" class="form-control" rows="4" required="required"/>
        </div>
        <div class="form-group">
            <label>Steps</label>
            <form:textarea path="steps" class="form-control" rows="4" required="required"/>
        </div>
        <div class="text-center">
            <input type="submit" class="btn btn-outline-dark w-25 mb-5 mt-3" value="Add"/>
        </div>

    </form:form>
</div>
</body>