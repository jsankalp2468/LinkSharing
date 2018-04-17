<%@ page import="linksharingapp.Subscription" %>
<% linksharingapp.User user = linksharingapp.User.findById(session.userId.toLong()) %>

<div class="row">

    <div class="col-lg-2">
        <img src="${createLink(controller: 'logIn', action: 'show', params: ["name": "${userSubscribedTopics.topic.createdBy.userName}"])}"  width="80" height="80">
    </div>

    <div class="col-lg-10">
        <div class="text-primary">
            %{--<a href="${createLink(controller:'topic', ation:'index' ,id:demo.id)}" class="text-primary pull-right">"${demo.topicName}"</a>--}%
            <a class="hyperlink" href="${createLink(controller:'topic', ation:'show' ,id:userSubscribedTopics.topic.id)}">${userSubscribedTopics.topic.name}</a>
        </div>

        <div class="col-lg-4" style="padding-left: 0px">
            <div class="text-muted">@${userSubscribedTopics.topic.createdBy.userName}</div>
            <a href="#" class="hyperlink"><ls:checkSubscribed topicId="${userSubscribedTopics.topic.id}"></ls:checkSubscribed> </a>
        </div>

        <div class="col-lg-4">
            <div class="text-muted">Subscriptions</div>
            <div class="text-primary"><ls:subscriptionCount topicId="${userSubscribedTopics.topic.id}"></ls:subscriptionCount> </div>
        </div>

        <div class="col-lg-2">
            <div class="text-muted">Topics</div>
            <div class="text-primary"><ls:topicCount user="${userSubscribedTopics.user}"></ls:topicCount> </div>
        </div>
        <div class="row">
            <span class="dropdown col-lg-3">
                <g:select id="seriousnessSelect" name="seriousness" from="${enumeration.Seriousness.values()}" optionValue="displayName"
                          optionKey="name" onchange="changeSeriousness(${userSubscribedTopics.id},this.value)"></g:select>
                %{--<select name="updatedSeriousness" id="updateSeriousness"--}%
                %{--onchange="changeSeriousness(${userSubscribedTopics.id}, this.value)">--}%
                %{--<option class="placeholder" selected disabled--}%
                %{--value="">${userSubscribedTopics.seriousness}</option>--}%
                %{--<option value="${enumeration.Seriousness.VERY_SERIOUS}">Very Serious</option>--}%
                %{--<option value="${enumeration.Seriousness.SERIOUS}">Serious</option>--}%
                %{--<option value="${enumeration.Seriousness.CASUAL}">Casual</option>--}%
                %{--</select>--}%
            </span>
            <span class="col-lg-7">
                <g:if test="${userSubscribedTopics.topic.createdBy == user}">
                    <span class="dropdown col-lg-6">
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Scope
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#">Private</a></li>
                            <li><a href="#">Public</a></li>
                        </ul>
                    </span>
                    <span class="col-lg-3"><i class="far fa-file fa-2x"></i></span>
                    <span class="col-lg-3"><i class="far fa-trash-alt fa-2x"></i></span>
                </g:if>
            </span>


            <span class="col-lg-2"><i class="far fa-envelope fa-2x"></i></span>
        </div>
    </div>




</div>


<script>
    function changeSeriousness(id,value) {
        console.log("Hiiiii")
        $.ajax({
            type: 'post',
            data: {'id': id, 'seriousness': value},
            url: 'http://localhost:8080/grails-app/subscription/update',
            dataType: 'json',
            success: function (res) {
                alert(res);
            },
            error: function (res) {
                $('#message').text('Error!');
                $('.dvLoading').hide();
            }
        });
    }
</script>