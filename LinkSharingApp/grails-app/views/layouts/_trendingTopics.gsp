<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<div class="panel-body">
    <g:if test="${unSubscribedTrendingTopics1}">
        <div class="row" style="padding-bottom:10px">
            <div class="col-lg-2">
                <img src="#" class="img-responsive">
            </div>

            <div class="col-lg-10">
                <div class="text-primary">
                    <a class="hyperlink"
                       href="${createLink(controller: 'topic', action: 'show', id: unSubscribedTrendingTopics1.id)}">${unSubscribedTrendingTopics1.name}</a>
                </div>

                <div class="col-lg-4" style="padding-left: 0px">
                    <span class="text-muted">@${unSubscribedTrendingTopics1.createdBy.userName}</span>
                    <a href="#" class="hyperlink">Subscribe</a>
                </div>

                <div class="col-lg-4">
                    <span class="text-muted">Subscriptions</span>
                    <span class="text-primary">${unSubscribedTrendingTopics1.count}</span>
                </div>

                <div class="col-lg-2">
                    <span class="text-muted">Topics</span>
                    <span class="text-primary">50</span>
                </div>
            </div>
        </div>
    </g:if>

    <g:if test="${subscribedTrendingTopics1}">
        <div class="row">

            <div class="col-lg-2">
                <img src="#" class="img-responsive">
            </div>

            <div class="col-lg-10">
                <g:form url="[controller: 'topic', action: 'show']">
                    <div class="col-lg-6" style="padding-left: 0px">
                        <input type="text" placeholder="Grails" name="name">
                    </div>

                    <div class="col-lg-3">
                        <button type="submit">show</button>
                    </div>

                    <div class="col-lg-3">
                        <button type="reset">cancel</button>
                    </div>
                </g:form>

                <div class="text-primary">
                    <a class="hyperlink"
                       href="${createLink(controller: 'topic', action: 'show', id: subscribedTrendingTopics1.id)}">${subscribedTrendingTopics1.name}</a>
                </div>

                <div class="col-lg-7" style="padding-left: 0px">
                    <div class="text-muted">@${subscribedTrendingTopics1.createdBy.userName}</div>
                    <a href="#" class="hyperlink">Unsubscribe</a>
                </div>

                <div class="col-lg-3">
                    <div class="text-muted">Subscriptions</div>

                    <div class="text-primary">${subscribedTrendingTopics1.count}</div>
                </div>

                <div class="col-lg-2">
                    <div class="text-muted">Topics</div>

                    <div class="text-primary">50</div>
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
                <ls:showSubscribe></ls:showSubscribe>
                <i class="far fa-envelope fa-2x"></i>
            </a>
            <a href="#">
                <i class="far fa-file fa-2x"></i>
            </a>
            <a href="#">
                <i class="far fa-trash-alt fa-2x"></i>
            </a>
        </div>
    </g:if>
</div>
</body>
</html>