package linksharingapp

import vo.TopPostVO
import vo.TopicVO

class LinkSharingTagLib {
    static defaultEncodeAs = "raw"
//    static defaultEncodeAs = [taglib:'html']
//    static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "ls"

    def checkRead = { attrs,body ->
        def value;
        Boolean aBoolean = new Boolean(attrs.isRead)
        if(session.user && session.user.readingItems){
            if(aBoolean){
                value = "Mark as UnRead"
            }else {
                value = "Mark as Read"
            }
        }
        else {
            value = null
        }

        out << body() << value
    }

    def getTopPosts = {
        List<TopPostVO> topPostVOList = Resource.getTopPosts()
//        out << <g:render template="topPosts" var="demo" collection="${lists}"></g:render>
//        out << render(template: 'topPosts',collection: topPostVOList,var: 'demo')
        out << g.render(template: '/logIn/topPosts', collection: topPostVOList,var: 'demo')
    }

    def getSubscribedTrendingTopics = {
        List<TopicVO> topicVOList = Topic.getTrendingTopics()
        List<TopicVO> subscribedTopicsList = []
        if(session.user){
            topicVOList.each {
                if (session.user.subscriptions.topic.name.contains(it.name)){
                    subscribedTopicsList.add(it)
                }

            }
        }
    out << g.render(template: "/layouts/trendingTopics", var: "subscribedTrendingTopics1", collection: subscribedTopicsList)
    }

    def getUnsubscribedTrendingTopics = {
        List<TopicVO> topicVOList = Topic.getTrendingTopics()
        List<TopicVO> unSubscribedTopicsList = []
        if(session.user){
            topicVOList.each {
                if (!session.user.subscriptions.topic.name.contains(it.name)){
                    unSubscribedTopicsList.add(it)
                }
            }
        }else {
            topicVOList.each {
                unSubscribedTopicsList.add(it)
            }
        }
        out << g.render(template: "/layouts/trendingTopics", var: "unSubscribedTrendingTopics1", collection: unSubscribedTopicsList)
    }

}

