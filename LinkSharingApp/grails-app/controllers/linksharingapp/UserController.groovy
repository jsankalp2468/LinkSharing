package linksharingapp

import co.SearchCO
import vo.TopicVO

class UserController {

    def index() {
        println(session.userId)
        if(session.userId){
            User user = User.findById(session.userId.toLong())
            Set<ReadingItem> unReadItems = user.readingItems
            render(view: 'index',model: [unReadItems:unReadItems])
        }
        else{
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
        if(session.userId){
            User user = User.findById(session.userId.toLong())
            render(view: 'showSubscribedTopics',  model: [topicList : user.getSubscribedTopics()])
        }
        else{
            redirect(controller:'logIn',action:'index')
        }
    }

//    def list(){
//        User user = User.findById(session.userId.toLong())
//        [users:User.list(params) , userCount:User.count()]
//    }
}