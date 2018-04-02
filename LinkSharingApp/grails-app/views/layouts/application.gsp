<!doctype html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <asset:stylesheet href="application.css"></asset:stylesheet>
    <asset:javascript src="application.js"></asset:javascript>
    <asset:stylesheet src="menu.css"></asset:stylesheet>

    <title></title>
    <g:layoutHead/>
</head>

<body>
<div class="container">
    <div class="page-header well">
        <span>

            <a class="text-primary" href="#" style="text-decoration: underline">Link Sharing</a>

        </span>
        <span class="search">
            <span class="fa fa-search"></span>
            <input placeholder="Search term">
            <span>
                <i class=" fa fa-times"></i>
            </span>
        </span>

    </div>
    <g:if test="${flash.error}">
        <h6>${flash.error}</h6>
    </g:if>
    <g:if test="${flash.message}">
        <h6>${flash.message}</h6>
    </g:if>
    <g:layoutBody/>

</div>
</body>
</html>
