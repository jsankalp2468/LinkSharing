<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>

<body>

<div id="myModal3" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">create resource</h4>
            </div>

            <div class="modal-body">
                <form class="form-horizontal" action="#">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="link">link:</label>

                        <div class="col-sm-10">
                            <input type="url" class="form-control" id="link" placeholder="Enter link"
                                   name="link">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="descrip">description:</label>

                        <div class="col-sm-10">
                            <textarea class="form-control" rows="5" id="descrip"></textarea>
                        </div>
                    </div>

                    <div class="dropdown">
                        <label class="control-label col-sm-2" for="topic">topic:</label>

                        <button class="btn btn-default dropdown-toggle" type="button"
                                data-toggle="dropdown" id="topic">topic
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a href="#">topictype1</a></li>
                            <li><a href="#">topictype2</a></li>
                            <li><a href="#">topictype3</a></li>

                        </ul>
                    </div>
                    <br>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">share</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close
                            </button>

                        </div>
                    </div>
                </form>

            </div>
            <!--<div class="modal-footer">-->
            <!--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>-->
            <!--</div>-->
        </div>

    </div>
</div>

</body>
</html>