package linksharingapp

import vo.TopicVO

class LinkResourceController {

    def index() { }

    def save(String url,String description,Long topicId){
        if (session.user){
            Topic topic = Topic.findById(topicId)
            LinkResource linkResource = new LinkResource(createdBy: session.user,description: description,topic:topic,url: url)
            if(linkResource.validate()){
                linkResource.save()
                flash.message = "Resource saved successfully"
//                render("successful")
                redirect(controller:'user',action : 'index')
            }
            else {
                flash.error = "Resource not saved"
                render("Resource not saved ${linkResource.errors.allErrors}")
            }
        }
        else {
            redirect(controller: 'logIn',action: 'index')
        }
    }
}
