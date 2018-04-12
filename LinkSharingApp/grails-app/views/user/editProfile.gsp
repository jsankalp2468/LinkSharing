<%--
  Created by IntelliJ IDEA.
  User: sankalp
  Date: 12/4/18
  Time: 11:24 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<% linksharingapp.User user = linksharingapp.User.findById(session.userId.toLong()) %>
<div class="col-lg-5">
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="col-lg-3">
                <img src="${createLink(controller: 'logIn', action: 'show', params: ["name": "${user.userName}"])}"
                     class="img-responsive">
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
            <span class="text-primary">Topics</span>
        </div>

        <div class="panel-body">
        %{--<g:render template="userSubscriptions" collection="${user.subscriptions}"--}%
        %{--var="userSubscribedTopics"></g:render>--}%
            <g:each in="${user.topics}" var="topic">
                <div class="row">

                    <div class="col-lg-2">
                        <img src="${createLink(controller: 'logIn', action: 'show', params: ["name": "${topic.createdBy.userName}"])}"
                             class="img-responsive">
                    </div>

                    <div class="col-lg-10">
                        <div class="text-primary">
                            %{--<a href="${createLink(controller:'topic', ation:'index' ,id:demo.id)}" class="text-primary pull-right">"${demo.topicName}"</a>--}%
                            <a class="hyperlink"
                               href="${createLink(controller: 'topic', ation: 'index', id: topic.resources[0].id)}">${topic.name}</a>
                        </div>

                        <div class="col-lg-4" style="padding-left: 0px">
                            <div class="text-muted">@${topic.createdBy.userName}</div>
                            <ls:checkSubscribed topicId="${topic.id}"></ls:checkSubscribed>
                        </div>

                        <div class="col-lg-4">
                            <div class="text-muted">Subscriptions</div>

                            <div class="text-primary"><ls:subscriptionCount
                                    topicId="${topic.id}"></ls:subscriptionCount></div>
                        </div>

                        <div class="col-lg-2">
                            <div class="text-muted">Topics</div>

                            <div class="text-primary"><ls:topicCount user="${user}"></ls:topicCount></div>
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
                    <i class="far fa-file fa-2x"></i>
                    <i class="far fa-trash-alt fa-2x"></i>


                    <i class="far fa-envelope fa-2x"></i>

                </div>

            </g:each>
        </div>
    </div>
</div>

<div class="col-lg-7">
    <div class="panel panel-default">
        <div class="panel-heading">
            Profile
        </div>

        <div class="panel-body">
            <g:form class="form-horizontal" method="POST" enctype="multipart/form-data" url="[controller: 'user',action: 'updateProfile']">
                <div class="form-group">
                    <label class="control-label col-lg-4">First Name</label>

                    <div class="col-lg-8">
                        <input type="text" class="form-control" name="firstName" value="${user?.firstName}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-4">Last Name</label>

                    <div class="col-lg-8">
                        <input type="text" class="form-control" name="lastName" value="${user?.lastName}">
                    </div>

                </div>

                <div class="form-group">
                    <label class="control-label col-lg-4">Username</label>

                    <div class="col-lg-8">
                        <input type="text" class="form-control" id="userName" name="userName" value="${user?.userName}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-4" for="document">Photo</label>

                    <div class="col-sm-8">
                        <input type="file" class="form-control" id="document" name="avatar" value="${user?.photo}">
                    </div>

                </div>

                <button type="submit" class="btn btn-primary" style="float: right">Update</button>

            </g:form>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            Change Password
        </div>

        <div class="panel-body">
            <g:form class="form-horizontal" method="POST" enctype="multipart/form-data"
                    url="[controller: 'user', action: 'changePassword']">
                <div class="form-group">
                    <label class="control-label col-lg-4">Old Password</label>

                    <div class="col-lg-8">
                        <input type="password" class="form-control" name="oldPassword">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-4">New Password</label>

                    <div class="col-lg-8">
                        <input type="password" class="form-control" name="newPassword">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-4">Confirm Password</label>

                    <div class="col-lg-8">
                        <input type="password" class="form-control" name="confirmPassword">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary" style="float: right">Update</button>

            </g:form>
        </div>
    </div>

</div>
</body>
</html>