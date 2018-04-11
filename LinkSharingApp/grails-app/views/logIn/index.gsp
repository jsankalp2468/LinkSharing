<%--
  Created by IntelliJ IDEA.
  User: sankalp
  Date: 2/4/18
  Time: 9:19 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>LogIn Page</title>
    <meta name="layout" content="application">
</head>

<body>

<div class="container">

    <div class="row">
        <div class="col-lg-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Recent Shares
                </div>

                <div class="panel-body">
                    <ls:recentShare/>
                </div>
            </div>
        </div>

        <div class="col-lg-4">
            <g:render template="logInHandler"></g:render>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="text">Top Posts</span>
                    <span class="dropdown" style="float: right">
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Today
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#">1 Week</a></li>
                            <li><a href="#">1 Month</a></li>
                            <li><a href="#">1 Year</a></li>
                        </ul>
                    </span>
                </div>

                <div class="panel-body">
                    <ls:getTopPosts></ls:getTopPosts>
                </div>
            </div>
        </div>

        <div class="col-lg-4">
            <g:render template="register"></g:render>
        </div>
    </div>
</div>

</body>
</html>