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

    </div>
</div>
</body>



