<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="nav.jsp"/>
<body class="show-all-bg">

<div class="container mx-auto">
    <h1 class="text-center mt-3">Recipe list</h1>

    <form action="/food-recipe/show-all?keyword=keyword" class="form-inline justify-content-center">
        <input type="text" name="keyword" class="form-control m-3" placeholder="Search"/>
        <input type="submit" class="btn btn-outline-dark" value="Search">
    </form>

    <div class="row">
        <c:forEach var="recipe" items="${recipes }">

            <div class="col-md-4 mb-5">
                <div class="card">
                    <div class="card-header bg-dark text-white">${recipe.title}</div>
                    <div class="card-body">${recipe.description}</div>
                    <div class="d-flex">

                        <div class="card-footer"><a href="/food-recipe/recipe-detail?id=${recipe.id}"
                                                    class="btn btn-primary">Detail</a></div>
                        <div class="card-footer"><a href="/food-recipe/update-recipe?id=${recipe.id}"
                                                    class="btn btn-primary">Update</a></div>
                        <div class="card-footer"><a href="/food-recipe/delete-recipel?id=${recipe.id}"
                                                    class="btn btn-primary">Delete</a></div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>