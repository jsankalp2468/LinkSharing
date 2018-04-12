<%--
  Created by IntelliJ IDEA.
  User: sankalp
  Date: 3/4/18
  Time: 12:59 PM
--%>

<%@ page import="linksharingapp.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="application">
</head>

<body>
<div class="col-lg-5">
    <div class="panel panel-default">
        <div class="panel-body">
            <%         linksharingapp.User user = linksharingapp.User.findById(session.userId.toLong())    %>
            <div class="col-lg-3">
                <img src="${createLink(controller: 'logIn',action: 'show', params: ["name":"${user.userName}"])}" class="img-responsive">
            </div>

            <div class="col-lg-9">
                <div class="text">
                    <h4>${user.name}</h4>
                </div>

                <div class="text-muted">
                    @${user.userName}
                </div>

                <div class="col-lg-4">
                    <div class="text-muted">Subscriptions</div>
                    <span class="text-primary"><ls:subscriptionCount></ls:subscriptionCount></span>
                </div>

                <div class="col-lg-3">
                    <div class="text-muted">Topics</div>
                    <span class="text-primary"><ls:topicCount user="${user}"></ls:topicCount></span>
                </div>

            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="text-primary">Subscriptions</span>
        </div>

        <div class="panel-body">
            <g:render template="userSubscriptions" collection="${user.subscriptions}" var="userSubscribedTopics"></g:render>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            Trending Topics
        </div>
        <ls:getSubscribedTrendingTopics></ls:getSubscribedTrendingTopics>
        <ls:getUnsubscribedTrendingTopics></ls:getUnsubscribedTrendingTopics>
    </div>
</div>

<div class="col-lg-7">
    <div class="panel panel-default">
        <div class="panel-heading">
            Inbox
        </div>

        <div class="panel-body">
            <g:render template="inbox" collection="${unReadItems}" var="unReadResource"></g:render>
        </div>

        <div class="panel-footer">
            <br/>
            <g:paginate total="${total}" prev="Previous" next="Next" controller="user" action="index" max="5"/><br/>
        </div>
    </div>
</div>
</body>
</html>