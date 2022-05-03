<jsp:include page="nav.jsp"/>


<body class="show-all-bg">
<div class="container">
    <div class="jumbotron">
        <h3><strong>${recipe.title}</strong></h3>
        <hr>
        <h4><kbd>Description</kbd></h4>
        <p>${recipe.description}</p>
        <hr>
        <h4><kbd>Ingredients</kbd></h4>
        <p>${recipe.ingredients}</p>
        <hr>
        <h4><kbd>Preparation</kbd></h4>
        <p>${recipe.steps}</p>
        <hr>
        <div class="d-flex">

            <div class="mx-3"><a href="/food-recipe/update-recipe?id=${recipe.id}"
                                        class="btn btn-primary">Update</a></div>
            <div class="mx-3"><a href="/food-recipe/delete-recipel?id=${recipe.id}"
                                        class="btn btn-primary">Delete</a></div>
        </div>
    </div>
</div>
</body>



