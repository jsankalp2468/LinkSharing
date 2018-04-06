<div class="row" style="padding-bottom: 10px">
    <div class="col-lg-2">
        <img class="img-responsive" src="#" alt="sankalp">
    </div>

    <div class="col-lg-10">
        <span class="text">${unReadResource.resource.createdBy.firstName}</span>
        <span class="text-muted">@${unReadResource.resource.createdBy.userName} 5min</span>
        <a href="${createLink(controller:'topic', ation:'index' ,id: unReadResource.resource.id)}" class="text-primary pull-right">${unReadResource.resource.topic.name}</a>

        <div class="text">
            <p>
                ${unReadResource.resource.description}
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
                    <ls:checkRead isRead="${unReadResource.isRead}"></ls:checkRead>
                </a>
            </div>

            <div class="col-lg-2">
                <a href="${createLink(controller: 'resource',action: 'index',id: unReadResource.resource.id)}" class="text-primary" style="text-decoration: underline;">View Post</a>
            </div>
        </div>
    </div>
</div>