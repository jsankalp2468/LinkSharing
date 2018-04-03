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
                    <div class="row" style="padding-bottom: 10px">
                        <div class="col-lg-2">
                            <img class="img-responsive" src="Sankalp%20%202814.JPG" alt="sankalp">
                        </div>

                        <div class="col-lg-10">
                            <span class="text">Sankalp Jain</span>
                            <span class="text-muted">@sankalp 5min</span>
                            <span class="text-primary" style="float: right">Grails</span>

                            <div class="text">
                                <p>
                                    Wikiversity Free course materials · Wikiquote Free quote compendium ·
                                    MediaWiki Free & open wiki application · Wikisource Free library ·
                                    Wikispecies Free species directory · Meta-Wiki Community coordination & documentation.
                                </p>
                            </div>

                            <div>
                                <i class="fab fa-facebook fa-2x"></i>
                                <i class="fab fa-tumblr fa-2x"></i>
                                <i class="fab fa-google-plus-g fa-2x"></i>
                                <a href="#" class="text-primary"
                                   style="text-decoration: underline;float: right">view post</a>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-2">
                            <img class="img-responsive" src="Sankalp%20%202814.JPG" alt="sankalp">
                        </div>

                        <div class="col-lg-10">
                            <span class="text">Sankalp Jain</span>
                            <span class="text-muted">@sankalp 5min</span>
                            <span class="text-primary" style="float: right">Grails</span>

                            <div class="text">
                                <p>
                                    Wikiversity Free course materials · Wikiquote Free quote compendium ·
                                    MediaWiki Free & open wiki application · Wikisource Free library ·
                                    Wikispecies Free species directory · Meta-Wiki Community coordination & documentation.
                                </p>
                            </div>

                            <div>
                                <i class="fab fa-facebook fa-2x"></i>
                                <i class="fab fa-tumblr fa-2x"></i>
                                <i class="fab fa-google-plus-g fa-2x"></i>
                                <a href="#" class="text-primary"
                                   style="text-decoration: underline;float: right">view post</a>
                            </div>
                        </div>
                    </div>
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
                    <g:render template="topPosts" var="demo" collection="${lists}"></g:render>
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