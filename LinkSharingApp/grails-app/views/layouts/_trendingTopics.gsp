<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<div class="panel-body">
    <g:if test="${session.user}">
        <g:if test="${!session.user.subscriptions.topic.name.contains(trendingTopics1.name)}">
            <div class="row" style="padding-bottom:10px">
                <div class="col-lg-2">
                    <img src="Sankalp%20%202814.JPG" class="img-responsive">
                </div>

                <div class="col-lg-10">
                    <div class="text-primary">
                        <a class="hyperlink" href="#">${trendingTopics1.name}</a>
                    </div>

                    <div class="col-lg-4" style="padding-left: 0px">
                        <span class="text-muted">@${trendingTopics1.createdBy.userName}</span>
                        <a href="#" class="hyperlink">Subscribe</a>
                    </div>

                    <div class="col-lg-4">
                        <span class="text-muted">Subscriptions</span>
                        <span class="text-primary">50</span>
                    </div>

                    <div class="col-lg-2">
                        <span class="text-muted">Topics</span>
                        <span class="text-primary">50</span>
                    </div>
                </div>
            </div>
        </g:if>

        <g:else>
            <div class="row">

                <div class="col-lg-2">
                    <img src="Sankalp%20%202814.JPG" class="img-responsive">
                </div>

                <div class="col-lg-10">
                    <div class="col-lg-6" style="padding-left: 0px">
                        <input type="text" placeholder="Grails">
                    </div>

                    <div class="col-lg-3">
                        <button type="submit">save</button>
                    </div>

                    <div class="col-lg-3">
                        <button type="reset">cancel</button>
                    </div>

                    <div class="text-primary">
                        <a class="hyperlink" href="#">${trendingTopics1.name}</a>
                    </div>

                    <div class="col-lg-4" style="padding-left: 0px">
                        <span class="text-muted">@${trendingTopics1.createdBy.userName}</span>
                        <a href="#" class="hyperlink">Unsubscribe</a>
                    </div>

                    <div class="col-lg-4">
                        <span class="text-muted">Subscriptions</span>
                        <span class="text-primary">50</span>
                    </div>

                    <div class="col-lg-2">
                        <span class="text-muted">Topics</span>
                        <span class="text-primary">50</span>
                    </div>
                </div>


                <span class="dropdown col-lg-offset-2">
                    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Seriousness
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Very Serious</a></li>
                        <li><a href="#">Serious</a></li>
                        <li><a href="#">Less Serious</a></li>
                    </ul>
                </span>

                <span class="dropdown">
                    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Scope
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Private</a></li>
                        <li><a href="#">Public</a></li>
                    </ul>
                </span>
                <a href="#">
                    <i class="far fa-envelope fa-2x"></i>
                </a>
                <a href="#">
                    <i class="far fa-file fa-2x"></i>
                </a>
                <a href="#">
                    <i class="far fa-trash-alt fa-2x"></i>
                </a>
            </div>
        </g:else>
    </g:if>
    <g:else>
        <%
            render(controller:'logIn',action : 'index')
            %>
    </g:else>
</div>
</body>
</html>