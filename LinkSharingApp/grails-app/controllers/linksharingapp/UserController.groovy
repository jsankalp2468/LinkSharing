package linksharingapp

import co.SearchCO
import vo.TopicVO

class UserController {

    def index() {
//        render("User Dashboard ${session.user.password}")
        List<TopicVO> topicVOList = Topic.getTrendingTopics()
        List<TopicVO> subscribedTopicsList = []
        List<TopicVO> unSubscribedTopicsList = []
        if(session.user && !session.user.subscriptions.topic.name.contains(topicVOList.name)){
            topicVOList.each {
                if (session.user.subscriptions.topic.name.contains(it.name)){
                    subscribedTopicsList.add(it)
                }
                else {
                    unSubscribedTopicsList.add(it)
                }
            }
        }else {
            topicVOList.each {
                unSubscribedTopicsList.add(it)
            }
        }
        println(subscribedTopicsList.id + " "+ subscribedTopicsList.name)
        println(unSubscribedTopicsList.id)
        render(view: 'index',model: [subscribedTopicsList:subscribedTopicsList,unSubscribedTopicsList:unSubscribedTopicsList])
    }

    def show() {
        SearchCO searchCO = new SearchCO()
        searchCO.setQ("topic")
        searchCO.setMax(5)
        searchCO.setOffset(0)
        render("${User.getUnReadResources(searchCO)}")

    }

    def showTrendingTopics() {
        List<TopicVO> topicVOList = Topic.getTrendingTopics()
        render("${topicVOList}")
    }

    def showSubscribedTopics() {
        if(session.user){
            render(view: 'showSubscribedTopics',  model: [topicList : session.user.getSubscribedTopics()])
        }
        else{
            redirect(controller:'logIn',action:'index')
        }
    }
}