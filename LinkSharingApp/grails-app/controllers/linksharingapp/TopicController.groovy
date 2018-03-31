package linksharingapp

import enumeration.Visibility

class TopicController {

    def index() { render("topic index")}

    def show(Long id){
        Topic topic = Topic.read(id)
        if (!topic) {
            flash.error = "NO SUCH TOPIC"
//            render("${params}")
            redirect(controller: 'logIn', action: 'index')
        }
        else {
            if(topic.visibility == Visibility.PUBLIC){
                render("success ${topic.toString()}")
            }
            else if(topic.visibility == Visibility.PRIVATE){
                Subscription subscription = Subscription.findByUserAndTopic(session.user,topic)
                if (subscription){
                    render("succcess")
                }
                else {
                    flash.error = "fash error set"
                    redirect(controller: 'logIn',action: 'index')
                }
            }
        }
    }

    def delete(Long id){
        Topic topic = Topic.load(id)
        println(topic.delete(flush:true))
        render("Topic Deleted Successfully")
    }
}
