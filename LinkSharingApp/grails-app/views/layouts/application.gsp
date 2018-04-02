<!doctype html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"
            integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ"
            crossorigin="anonymous"></script>
    <title></title>
    <g:layoutHead/>
    <style>

    .search {
        position: relative;
        color: #aaa;
        font-size: 16px;
        float: right;
        border-radius: 50px
    }

    .search input {
        width: 250px;
        height: 32px;

        background: #fcfcfc;
        border: 1px solid #aaa;
        border-radius: 15px;
        /*box-shadow: 0 0 3px #ccc, 0 10px 15px #ebebeb inset;*/
    }

    .search input { text-indent: 32px;}
    .fa-search {
        position: absolute;
        top: 10px;
        left: 10px;
    }
    .fa-times{
        position:absolute;
        top: 10px;
        right: 10px;

    }
    </style>
</head>

<body>
<div class="container">
    <div class="page-header well">
        <span>

            <a class="text-primary" href="#" style="text-decoration: underline">Link Sharing</a>

        </span>
        <span class="search">
            <span class="fa fa-search"></span>
            <input placeholder="Search term">
            <span>
                <i class=" fa fa-times"></i>
            </span>
        </span>

    </div>
    <g:layoutBody/>

</div>
</body>
</html>