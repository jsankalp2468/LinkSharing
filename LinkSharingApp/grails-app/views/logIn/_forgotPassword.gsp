<!DOCTYPE html>
<html>
<head>
    <title>forgot password</title>
</head>

<body>
<div id="forgotPassword" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Forgot Password</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" controller="logIn" action="sendMailWhenForgotPassword">
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="userName1">UserName :</label>

                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="userName1" name="userName1">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4" for="email1">email</label>

                        <div class="col-sm-8">
                            <input type="email" class="form-control" id="email1" name="email1">
                        </div>
                    </div>

                    <br>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Change Password</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </g:form>

            </div>

        </div>

    </div>
</div>

</body>
</html>