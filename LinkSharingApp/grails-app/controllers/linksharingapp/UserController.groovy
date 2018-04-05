package linksharingapp

import co.SearchCO
import vo.TopicVO

class UserController {

    def index() {
//        render("User Dashboard ${session.user.password}")
        if (session.user){
            List<TopicVO> topicVOList = Topic.getTrendingTopics()
            render(view: 'index', model: [trendingTopics: topicVOList])
        }
        else {
            redirect(controller: 'logIn',action: 'index')
        }
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