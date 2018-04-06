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
        render(view: 'showResources',model: [resource:resource])
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
        Topic topic = Topic.findByName(params.searchKey)
        if (!topic){
            flash.error = "Search not found"
            redirect(controller : 'logIn' , action : 'index')
        }
        else {
            SearchCO co = new ResourceSearchCO()
            co.topicId=topic.id
            co.q = topic.visibility
            if(co.q){
                co.setVisibility(topic.visibility)
            }
            println(co.topicId)
            List<Resource> resources = Resource.search(co).list()
            render(view: 'searchResource',model: [resourceList:resources])
        }
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
