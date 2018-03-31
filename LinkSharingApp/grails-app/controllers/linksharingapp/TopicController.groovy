package linksharingapp

import enumeration.Visibility

class TopicController {

    def index() { }

    def show(Long id){
        Topic topic = Topic.findById(id)
        if (!topic) {
            flash.error = "NO SUCH TOPIC"
            redirect(controller: 'logIn', action: 'index')
        }
        else {
            if(topic.visibility == Visibility.PUBLIC){
                render("success")
            }
        }
    }
}
