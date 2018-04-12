<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>

<body>
<div class="row">
    <% linksharingapp.Resource resource = linksharingapp.Resource.findById(demo.id)%>
    <div class="col-lg-2">
        <img src="${createLink(controller: 'logIn',action: 'show', params: ["name":"${demo.createdBy.userName}"])}" width="80" height="80">    </div>

    <div class="col-lg-10">
        <span class="text">${demo.createdBy.firstName}</span>
        <span class="text-muted">@"${demo.createdBy.userName}" "${resource.lastUpdated}"</span>
        <a href="${createLink(controller:'topic', ation:'index' ,id:demo.id)}" class="text-primary pull-right">"${demo.topicName}"</a>

        <div class="text">
            <p>
                ${resource.description}
            </p>
        </div>

        <div>
            <i class="fab fa-facebook fa-2x"></i>
            <i class="fab fa-tumblr fa-2x"></i>
            <i class="fab fa-google-plus-g fa-2x"></i>
            <a href="${createLink(controller: 'resource',action: 'index',id:demo.id)}" class="text-primary pull-right" style="text-decoration: underline">view post</a>
        </div>
    </div>
</div>
</body>
</html>