package linksharingapp

class DocumentResourceController {

    def userService

    def index() { }

    def save() {
        User user = userService.findUserFromUserId(session.userId)
        if (user){
            Topic topic = Topic.findById(params.topicId)
            DocumentResource documentResource = new DocumentResource(createdBy: user,description: params.description,topic:topic)
            if(documentResource.validate()){
                documentResource.save()
                def avatar = request.getFile('document')
                avatar.transferTo(new java.io.File("/home/sankalp/Desktop/Documents/${documentResource.id}.pdf"))
                topic.addToResources(documentResource)
                user.addToResources(documentResource)
                flash.message = "Resource saved successfully"
//                render("successful")
                redirect(controller:'user',action : 'index')
            }
            else {
                flash.error = "Resource not saved"
//                render("Resource not saved ${documentResource.errors.allErrors}")
                redirect(controller: 'logIn',action: 'index')

            }
        }
        else {
            flash.message = "Please LogIn to continue"
            redirect(controller: 'logIn',action: 'index')
        }
    }


    def show(){
        def file = new File("/home/sankalp/Desktop/Documents/46.pdf")
        def img = file.bytes
        response.contentType = '*' // or the appropriate image content type
        response.outputStream << img
        response.outputStream.flush()
    }
}
