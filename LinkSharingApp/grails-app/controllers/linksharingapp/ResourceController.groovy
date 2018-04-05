package linksharingapp

import co.ResourceSearchCO
import co.SearchCO
import enumeration.Visibility
import vo.RatingInfoVO
import vo.TopPostVO
import vo.TopicVO

class ResourceController {

    def index(Long id) {
        Resource resource = Resource.findById(id)
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
//        println(subscribedTopicsList.id + " "+ subscribedTopicsList.name)
//        println(unSubscribedTopicsList.id)
        render(view: 'showResources',model: [resource:resource,subscribedTopicsList:subscribedTopicsList,unSubscribedTopicsList:unSubscribedTopicsList])
    }

    def delete(Long id){
        Resource resource = Resource.load(id)
        //if println(resource.id) it throw error at resource.delete wali line
        //but if we assign a value to it then it thrown exception at prsource.id=50
        println(resource.id)
        try{
            println(resource.delete(flush:true))//returns null
            render("Resource deleted successfully")
        }
        catch (RuntimeException ex){
            render("Resource not found")
        }
    }

    def searchResource() {
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
        List<TopPostVO> topPostVOList = Resource.getTopPosts()
        Topic topic = Topic.findByName(params.searchKey)
//        ResourceSearchCO co = new ResourceSearchCO(topicId: topic.id,visibility: topic.visibility,q: 'mytopic0')
        SearchCO co = new ResourceSearchCO()
        co.topicId=topic.id
        co.q = topic.visibility
        if(co.q){
            co.setVisibility(topic.visibility)
        }
        println(co.topicId)
        List<Resource> resources = Resource.search(co).list()
        println(resources)
        render(view: 'searchResource',model: [resourceList:resources,topPostLists:topPostVOList,subscribedTopicsList:subscribedTopicsList,unSubscribedTopicsList:unSubscribedTopicsList])
    }

    def showResources(Long id){
        Resource resource = Resource.findById(id)
        RatingInfoVO ratingInfoVO = resource.method()
//        render("${ratingInfoVO.totalVotes} ${ratingInfoVO.averageScore} ${ratingInfoVO.totalScore}")
        render("hello")
    }

    def showTrendingTopics(){
        List<TopicVO> topicVOList = Topic.getTrendingTopics()
        render("${topicVOList}")
    }
}
