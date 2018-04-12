<div class="row">
    <div class="col-lg-3">
        <img src="${createLink(controller: 'logIn', action: 'show', params: ["name": "${subscriptions.userName}"])}" class="img-responsive">
    </div>

    <div class="col-lg-9">
        <div class="text">
            <h4>${subscriptions.firstName}</h4>
        </div>

        <div class="text-muted">
            @${subscriptions.userName}
        </div>

        <div class="col-lg-4">
            <div class="text-muted">Subscriptions</div>

            <div class="text-primary"><ls:subscriptionCount
                    user="${subscriptions}"></ls:subscriptionCount></div>
        </div>

        <div class="col-lg-3">
            <div class="text-muted">Topics</div>

            <div class="text-primary"><ls:topicCount user="${subscriptions}"></ls:topicCount></div>
        </div>

    </div>
</div>
<br>