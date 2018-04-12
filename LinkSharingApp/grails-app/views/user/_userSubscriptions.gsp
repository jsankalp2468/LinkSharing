<% linksharingapp.User user = linksharingapp.User.findById(session.userId.toLong()) %>

<div class="row">

    <div class="col-lg-2">
        <img src="${createLink(controller: 'logIn', action: 'show', params: ["name": "${userSubscribedTopics.topic.createdBy.userName}"])}" class="img-responsive">
    </div>

    <div class="col-lg-10">
        <div class="text-primary">
            %{--<a href="${createLink(controller:'topic', ation:'index' ,id:demo.id)}" class="text-primary pull-right">"${demo.topicName}"</a>--}%
            <a class="hyperlink" href="${createLink(controller:'topic', ation:'index' ,id:userSubscribedTopics.id)}">${userSubscribedTopics.topic.name}</a>
        </div>

        <div class="col-lg-4" style="padding-left: 0px">
            <div class="text-muted">@${userSubscribedTopics.topic.createdBy.userName}</div>
            <a href="#" class="hyperlink"><ls:checkSubscribed topicId="${userSubscribedTopics.topic.id}"></ls:checkSubscribed> </a>
        </div>

        <div class="col-lg-4">
            <div class="text-muted">Subscriptions</div>
            <div class="text-primary"><ls:subscriptionCount topicId="${userSubscribedTopics.topic.id}"></ls:subscriptionCount> </div>
        </div>

        <div class="col-lg-2">
            <div class="text-muted">Topics</div>
            <div class="text-primary"><ls:topicCount user="${userSubscribedTopics.user}"></ls:topicCount> </div>
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
        %{--<g:form id="selectForm" controller="logIn" action="index" method="POST" class="pull-right">--}%
            %{--<g:select id="topPostSelect" name="topPostFilter" from="${enumeration.TopPostFilter.values()}" optionValue="displayName" optionKey="name" onchange="this.form.submit()"></g:select>--}%
        %{--</g:form>--}%
    </span>

    <g:if test="${userSubscribedTopics.topic.createdBy == user}">
        <span class="dropdown">
            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Scope
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="#">Private</a></li>
                <li><a href="#">Public</a></li>
            </ul>
        </span>
        <i class="far fa-file fa-2x"></i>
        <i class="far fa-trash-alt fa-2x"></i>
    </g:if>


    <i class="far fa-envelope fa-2x"></i>


</div>
