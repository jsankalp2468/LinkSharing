<div class="row" style="padding-bottom: 10px">
    <div class="col-lg-2">
        <img src="${createLink(controller: 'logIn', action: 'show', params: ["name": "${recentSharePost.createdBy.userName}"])}"
             class="img-responsive">
    </div>

    <div class="col-lg-10">
        <span class="text">${recentSharePost.createdBy.name}</span>
        <span class="text-muted">${recentSharePost.createdBy.userName} ${recentSharePost.dateCreated}</span>
        <span class="text-primary" style="float: right">
            <a href="${createLink(controller: 'topic', ation: 'index', id: recentSharePost.id)}"
                class="text-primary pull-right">${recentSharePost.topic.name}</a>
        </span>

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