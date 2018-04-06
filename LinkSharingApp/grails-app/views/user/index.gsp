<%--
  Created by IntelliJ IDEA.
  User: sankalp
  Date: 3/4/18
  Time: 12:59 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="application">
</head>

<body>
<div class="col-lg-5">
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="col-lg-3">
                <img src="#" class="img-responsive">
            </div>

            <div class="col-lg-9">
                <div class="text">
                    <h4>${session.user.name}</h4>
                </div>

                <div class="text-muted">
                    @${session.user.userName}
                </div>

                <div class="col-lg-4">
                    <span class="text-muted">Subscriptions</span>
                    <span class="text-primary">${session.user.subscriptions.size()}</span>
                </div>

                <div class="col-lg-3">
                    <span class="text-muted">Topics</span>
                    <span class="text-primary">${session.user.topics.size()}</span>
                </div>

            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="text-primary">Subscriptions</span>
            <span style="float: right">
                <a href="#" class="hyperlink">View All</a>
            </span>
        </div>

        <div class="panel-body">
            <div class="row">

                <div class="col-lg-2">
                    <img src="#" class="img-responsive">
                </div>

                <div class="col-lg-10">
                    <div class="text-primary">
                        <a class="hyperlink" href="#">Grails</a>
                    </div>

                    <div class="col-lg-4" style="padding-left: 0px">
                        <span class="text-muted">@sankalp</span>
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
                <i class="far fa-envelope fa-2x"></i>
                <i class="far fa-file fa-2x"></i>
                <i class="far fa-trash-alt fa-2x"></i>

            </div>

            <div class="row">
                <div class="col-lg-2">
                    <img src="#" class="img-responsive">
                </div>

                <div class="col-lg-10">
                    <div class="text-primary">
                        <a class="hyperlink" href="#">Grails</a>
                    </div>

                    <div class="col-lg-4" style="padding-left: 0px">
                        <span class="text-muted">@sankalp</span>
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


                <div style="float:right; padding-right: 15px">
                    <span class="dropdown">
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Seriousness
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
            <div class="row" style="padding-bottom: 10px">
                <div class="col-lg-2">
                    <img class="img-responsive" src="#" alt="sankalp">
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
                        <div class="col-lg-2" style="padding-left: 0px;padding-right: 0px">
                            <i class="fab fa-facebook fa-2x"></i>
                            <i class="fab fa-tumblr fa-2x"></i>
                            <i class="fab fa-google-plus-g fa-2x"></i>
                        </div>

                        <div class="col-lg-2">
                            <a href="#" class="text-primary" style="text-decoration: underline;">Download</a>
                        </div>

                        <div class="col-lg-3">
                            <a href="#" class="text-primary" style="text-decoration: underline;">View Full Size</a>
                        </div>

                        <div class="col-lg-3">
                            <a href="#" class="text-primary" style="text-decoration: underline;">
                                <ls:checkRead isRead="false"></ls:checkRead>
                            </a>
                        </div>

                        <div class="col-lg-2">
                            <a href="${createLink(controller: 'resource',action: 'index',id: 1)}" class="text-primary" style="text-decoration: underline;">View Post</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-2">
                    <img class="img-responsive" src="#" alt="sankalp">
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
                        <div class="col-lg-2" style="padding-left: 0px;padding-right: 0px">
                            <i class="fab fa-facebook fa-2x"></i>
                            <i class="fab fa-tumblr fa-2x"></i>
                            <i class="fab fa-google-plus-g fa-2x"></i>
                        </div>

                        <div class="col-lg-2">
                            <a href="#" class="text-primary" style="text-decoration: underline;">Download</a>
                        </div>

                        <div class="col-lg-3">
                            <a href="#" class="text-primary" style="text-decoration: underline;">View Full Size</a>
                        </div>

                        <div class="col-lg-3">
                            <a href="#" class="text-primary" style="text-decoration: underline;">Mark As Read</a>
                        </div>

                        <div class="col-lg-2">
                            <a href="#" class="text-primary" style="text-decoration: underline;">View Post</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>