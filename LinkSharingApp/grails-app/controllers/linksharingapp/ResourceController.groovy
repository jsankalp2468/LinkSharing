package linksharingapp

import co.ResourceSearchCO
import co.SearchCO
import enumeration.Visibility

class ResourceController {

    def index() { }

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

    def search() {
        SearchCO co = new ResourceSearchCO()
        if(co.q){
            co.setVisibility(Visibility.PUBLIC)
        }
//        ResourceSearchCO co = new ResourceSearchCO(topicId: 1,visibility: Visibility.PUBLIC)
        List<Resource> resources = Resource.search(co).list()
        render("${resources}")
    }
}
