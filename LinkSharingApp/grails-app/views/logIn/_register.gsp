<%--
  Created by IntelliJ IDEA.
  User: sankalp
  Date: 3/4/18
  Time: 4:50 PM
--%>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta name="layout" content="application">
</head>

<body>
<div class="panel panel-default">
    <div class="panel-heading">
        Sign Up
    </div>

    <div class="panel-body">
        <g:form class="form-horizontal" method="post" enctype="multipart/form-data"
                url="[controller: 'logIn', action: 'register']">
            <div class="form-group">
                <label class="control-label col-lg-4">First Name</label>

                <div class="col-lg-8">
                    <input type="text" class="form-control" name="firstName" value="${user?.firstName}">
                </div>
                <g:hasErrors bean="${user}" field="firstName">
                    <g:eachError bean="${user}" field="firstName">
                        <p style="color: red;"><g:message error="${it}"/></p>
                    </g:eachError>
                </g:hasErrors>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-4">Last Name</label>

                <div class="col-lg-8">
                    <input type="text" class="form-control" name="lastName" value="${user?.lastName}">
                </div>
                <g:hasErrors bean="${user}" field="lastName">
                    <g:eachError bean="${user}" field="lastName">
                        <p style="color: red;"><g:message error="${it}"/></p>
                    </g:eachError>
                </g:hasErrors>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-4">Email</label>

                <div class="col-lg-8">
                    <input type="text" class="form-control" name="email" value="${user?.email}">
                </div>

                <g:hasErrors bean="${user}" field="email">
                    <g:eachError bean="${user}" field="email">
                        <p style="color: red;"><g:message error="${it}"/></p>
                    </g:eachError>
                </g:hasErrors>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-4">Username</label>

                <div class="col-lg-8">
                    <input type="text" class="form-control" id="userName" name="userName" value="${user?.userName}">
                </div>

                <g:hasErrors bean="${user}" field="userName">
                    <g:eachError bean="${user}" field="userName">
                        <p style="color: red;"><g:message error="${it}"/>
                        %{--<g:message code="default.not.unique.message" args="[]"></g:message>--}%
                        </p>
                    </g:eachError>
                </g:hasErrors>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-4">Password</label>

                <div class="col-lg-8">
                    <input type="password" class="form-control" name="password" value="${user?.password}">
                </div>

                <g:hasErrors bean="${user}" field="password">
                    <g:eachError bean="${user}" field="password">
                        <p style="color: red;"><g:message error="${it}"/></p>
                    </g:eachError>
                </g:hasErrors>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-4">Confirm Password</label>

                <div class="col-lg-8">
                    <input type="password" class="form-control" name="confirmPassword">
                </div>

                <g:hasErrors bean="${user}" field="confirmPassword">
                    <g:eachError bean="${user}" field="confirmPassword">
                        <p style="color: red;"><g:message error="${it}"/></p>
                    </g:eachError>
                </g:hasErrors>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-4" for="document">Photo</label>

                <div class="col-sm-8">
                    <input type="file" class="form-control" id="document" name="avatar" value="${user?.photo}">
                </div>
                <g:hasErrors bean="${user}" field="photo">
                    <g:eachError bean="${user}" field="photo">
                        <p style="color: red;"><g:message error="${it}"/></p>
                    </g:eachError>
                </g:hasErrors>
            </div>

            <button type="submit" class="btn btn-primary" style="float: right">Register</button>

        </g:form>
    </div>
</div>

</body>
</html>