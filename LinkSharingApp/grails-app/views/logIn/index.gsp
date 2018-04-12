<%--
  Created by IntelliJ IDEA.
  User: sankalp
  Date: 2/4/18
  Time: 9:19 PM
--%>

<%@ page import="vo.TopPostVO" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>LogIn Page</title>
    <meta name="layout" content="application">
</head>

<body>

<div class="container">

    <div class="col-lg-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                Recent Shares
            </div>

            <div class="panel-body">
                <ls:recentShare/>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <span class="text">Top Posts</span>

                <g:form id="selectForm" controller="logIn" action="index" method="POST" class="pull-right">
                    <g:select id="topPostSelect" name="topPostFilter" from="${enumeration.TopPostFilter.values()}" optionValue="displayName" optionKey="name" onchange="this.form.submit()"></g:select>
                </g:form>

            </div>

            <div class="panel-body">
                <ls:getTopPosts topPostFilter="${enumeration.TopPostFilter.changeForm(topPostFilter)}"></ls:getTopPosts>
            </div>
        </div>
    </div>

    <div class="col-lg-4">
        <g:render template="logInHandler"></g:render>
        <g:render template="register"></g:render>
    </div>
</div>

</body>
</html>