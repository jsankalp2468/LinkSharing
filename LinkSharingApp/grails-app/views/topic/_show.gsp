<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta name="layout" content="application">
</head>

<body>
<div class="col-lg-5">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="text-primary">Topic "${resources1[0].topic.name}"</span>
        </div>

        <div class="panel-body">
            <div class="row">
                <div class="col-lg-2">
                    <img src="${createLink(controller: 'logIn', action: 'show', params: ["name": "${resources1[0].topic.createdBy.userName}"])}"
                         class="img-responsive">
                </div>

                <div class="col-lg-10">
                    <div class="text-primary">
                        <span class="text-primary">${resources1[0].topic.name}</span>
                    </div>

                    <div class="col-lg-5" style="padding-left: 0px">
                        <div class="text-muted">@${resources1[0].topic.createdBy.firstName}</div>
                        <ls:checkSubscribed topicId="${resources1[0].topic.id}"></ls:checkSubscribed>
                    </div>

                    <div class="col-lg-3">
                        <span class="text-muted">Subscriptions</span>
                        <span class="text-primary"><ls:subscriptionCount
                                topicId="${resources1[0].topic.id}"></ls:subscriptionCount></span>
                    </div>

                    <div class="col-lg-2">
                        <span class="text-muted">Posts</span>
                        <span class="text-primary"><ls:resourceCount
                                topicId="${resources1[0].topic.id}"></ls:resourceCount></span>
                    </div>
                </div>


                <div style="float:right; padding-right: 15px">
                    <span class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Seriousness
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#">Very Serious</a></li>
                            <li><a href="#">Serious</a></li>
                            <li><a href="#">Less Serious</a></li>
                        </ul>
                    </span>
                    <i class="far fa-envelope fa-2x"></i>
                </div>

            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-body">
            <g:render template="/layouts/userBlock" collection="${subscribedUsers1}" var="subscriptions"></g:render>
        </div>
    </div>

</div>

<div class="col-lg-7">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="text-primary">Posts : "${resources1[0].topic.name}"</span>
            %{--<g:form class="pull-right">--}%
            %{--<g:select name="resources" optionKey="id" optionValue="createdBy" from="${resources1[0].topic.resources}"></g:select>--}%
            %{--<span class="caret"></span>--}%
            %{--</g:form>--}%
        </div>

        <div class="panel-body">
            <g:each in="${resources1}" var="resource">
                <div class="row" style="padding-bottom: 10px">
                    <div class="col-lg-2">
                        <img src="${createLink(controller: 'logIn', action: 'show', params: ["name": "${resource.createdBy.userName}"])}" class="img-responsive">
                    </div>

                    <div class="col-lg-10">
                        <div class="text">
                            <p>
                                ${resource.description}
                            </p>
                        </div>

                        <div>
                            <div class="col-lg-2" style="padding-left: 0px;padding-right: 0px">
                                <i class="fab fa-facebook fa-2x"></i>
                                <i class="fab fa-tumblr fa-2x"></i>
                                <i class="fab fa-google-plus-g fa-2x"></i>
                            </div>

                            <g:if test="${linksharingapp.Resource.findTypeOfResource(resource.id) == "DocumentResource"}">
                                <div class="col-lg-4">
                                    <a href="#" class="text-primary" style="text-decoration: underline;">Download</a>
                                </div>
                            </g:if>

                            <g:else>
                                <div class="col-lg-4">
                                    <a href="${resource.url}" class="text-primary" style="text-decoration: underline;" target="_blank">View Full Site</a>
                                </div>
                            </g:else>

                            <div class="col-lg-3">
                                <a href="#" class="text-primary" style="text-decoration: underline;">
                                    <ls:checkRead resource="${resource}"></ls:checkRead>
                                </a>
                            </div>

                            <div class="col-lg-2">
                                <a href="${createLink(controller: 'resource',action: 'index',id:resource.id)}" class="text-primary pull-right" style="text-decoration: underline">view post</a>
                            </div>
                        </div>
                    </div>
                </div>
            </g:each>
        </div>
    </div>
</div>
</body>
</html>
