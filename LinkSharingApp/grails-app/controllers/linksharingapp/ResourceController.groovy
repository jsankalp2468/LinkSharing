package linksharingapp

class ResourceController {

    def index() { }

    def delete(Long id){
        Resource resource = Resource.load(id)
        println(resource.delete(flush:true))//returns null
        render("Resource deleted successfully")
    }
}
