<div class="row" style="padding-bottom: 10px">
    <div class="col-lg-2">
        <img class="img-responsive" src="#" alt="sankalp">
    </div>

    <div class="col-lg-10">
        <span class="text">${recentSharePost.createdBy.name}</span>
        <span class="text-muted">${recentSharePost.createdBy.userName} ${recentSharePost.dateCreated}</span>
        <span class="text-primary" style="float: right">${recentSharePost.topic.name}</span>

        <div class="text">
            <p>
                ${recentSharePost.description}
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