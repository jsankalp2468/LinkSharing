package linksharingapp

import enumeration.TopPostFilter
import vo.TopPostVO
import vo.TopicVO

class LinkSharingTagLib {
    static defaultEncodeAs = "raw"
//    static defaultEncodeAs = [taglib:'html']
//    static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "ls"

    def checkRead = { attrs, body ->
        def value
        if (session.userId) {
            linksharingapp.User user = User.findById(session.userId.toLong())
            ReadingItem readingItem = ReadingItem.findByUserAndResource(user, attrs.resource)
            if (readingItem) {
                if (readingItem.isRead) {
                    value = "Mark as Read"
                } else {
                    value = "Mark as UnRead"
                }
            } else {
                value = null
            }
        } else {
            value = null
        }

        out << body() << value
    }

    def getTopPosts = {attrs->
        println(attrs.topPostFilter)
        List<TopPostVO> topPostVOList = Resource.getTopPosts(attrs.topPostFilter ?: TopPostFilter.TODAY)
        println(topPostVOList.id)

//        out << <g:render template="topPosts" var="demo" collection="${lists}"></g:render>
//        out << render(template: 'topPosts',collection: topPostVOList,var: 'demo')
        out << g.render(template: '/logIn/topPosts', collection: topPostVOList, var: 'demo')
    }

    def getSubscribedTrendingTopics = {
        List<TopicVO> topicVOList = Topic.getTrendingTopics()
        List<TopicVO> subscribedTopicsList = []
        if (session.userId) {
            linksharingapp.User user = User.findById(session.userId.toLong())
            topicVOList.each {
                if (user.subscriptions.topic.name.contains(it.name)) {
                    subscribedTopicsList.add(it)
                }

            }
        }
        out << g.render(template: "/layouts/trendingTopics", var: "subscribedTrendingTopics1", collection: subscribedTopicsList)
    }

    def getUnsubscribedTrendingTopics = {
        List<TopicVO> topicVOList = Topic.getTrendingTopics()
        List<TopicVO> unSubscribedTopicsList = []
        if (session.userId) {
            linksharingapp.User user = User.findById(session.userId.toLong())
            topicVOList.each {
                if (!user.subscriptions.topic.name.contains(it.name)) {
                    unSubscribedTopicsList.add(it)
                }
            }
        } else {
            topicVOList.each {
                unSubscribedTopicsList.add(it)
            }
        }
        out << g.render(template: "/layouts/trendingTopics", var: "unSubscribedTrendingTopics1", collection: unSubscribedTopicsList)
    }

    def showSubscribe = { attrs, body ->
        def value
        if (attrs.topicId && session.userId) {
            value = "delete"
        } else {
            value = "save"
        }
        out << body() << value
    }

    def subscriptionCount = { attrs, body ->
        if (attrs.topicId) {
            Topic topic = Topic.findById(attrs.topicId.toLong())
            out << body() << topic.subscriptions.size()
        } else if (!session.userId) {
//            linksharingapp.User user = User.findById(session.userId.toLong())
            out << body() << attrs.user.subscriptions.size()
        }else if (session.userId) {
            linksharingapp.User user = User.findById(session.userId.toLong())
            out << body() << user.subscriptions.size()
        }

    }

    def resourceCount = { attrs, body ->
        Topic topic = Topic.findById(attrs.topicId.toLong())
        out << body() << topic.resources.size()
    }

    def topicCount = { attrs, body ->
//        linksharingapp.User user = User.findById(session.userId.toLong())
        out << body() << attrs.user.topics.size()
    }

    def canDeleteResource = { attrs ->
        def value
        if(session.userId){
            Resource resource = Resource.findById(attrs.resourceId)
            User user1 = User.findById(session.userId.toLong())
            if(user1.canDeleteResourceMethod(resource)){
                value = "delete"
            }else{
                value = null
            }
        }else{
            value = null
        }
        out<< value
    }

    def checkSubscribed = {attrs,body->
        def value
        if(session.userId){
//            println(attrs.topicId)
            Topic topic = Topic.findById(attrs.topicId)
            User user1 = User.findById(session.userId.toLong())
//            println(user1)
//            println(topic.createdBy)
            if(user1.id == topic.createdBy.id){
                value = null
            }else if(user1.isSubscribed(topic.id)){
                out<<"<a href=\"${createLink(controller: 'subscription', action: 'delete', id: topic.id)}\" class=\"hyperlink\">Unsubscribe</a>"
//                out<<body()<<g.createLink(controller: 'subscription',action: 'delete',id: topic.id)<<value
//                out<<body()<<g.link(controller: 'subscription',action: 'delete',id: topic.id)
//                value = "Unsubscribe"
            }else{
                out<<"<a href=\"#\" class=\"hyperlink\">Subscribe</a>"
            }
        }else{
            out<<"<a href=\"#\" class=\"hyperlink\">Subscribe</a>"
        }
        out<< value
    }

    def editResource = {
        def value
        if(session.user){
            value = "Edit"
        }else{
            value = null
        }

        out << value
    }

    def recentShare = {
        List<Resource> recentShares = Resource.createCriteria().list([max:2]) {
            order 'id','desc'
        }
        out << g.render(template: "/logIn/recentShares", collection: recentShares, var: "recentSharePost")
    }


}

