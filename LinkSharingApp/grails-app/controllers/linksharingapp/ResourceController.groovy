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
        String resourceType = Resource.findTypeOfResource(id)
        render(view: 'showResources',model: [resource:resource,resourceType : resourceType])
    }

    def delete(){
        Long id = new Long(params.id)
        println(id)
        Resource resource = Resource.load(id)
        def listOfReadingItems = ReadingItem.findAllByResource(resource)
        def listOfResourceRating = ResourceRating.findAllByResource(resource)
        println(resource)
        if (session.user && (session.user.admin || session.user == resource.createdBy)){
//            try{
                println(resource.delete(flush:true))//returns null
//            listOfReadingItems*.delete(flush: true)
//            listOfResourceRating*.delete(flush: true)
                flash.message = "Resource deleted successfully"
                redirect(controller: 'logIn',action: 'index')
//            }
//            catch (RuntimeException ex){
//                flash.error = "Resource not deleted"
//                redirect(controller: 'logIn',action: 'index')
//            }
        }else{
            flash.error = "Deletion of the Resource : ${resource} is not allowed"
            redirect(controller: 'logIn',action: 'index')
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

    def findTypeOfResource(){
        Resource.findTypeOfResource(2)
        render("sucess")
    }
}
