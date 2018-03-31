package linksharingapp

import co.ResourceSearchCO
import enumeration.Visibility

import javax.servlet.http.HttpSession

class TopicController {

    def index() { render("topic index")}


    def show(ResourceSearchCO co,Long id){
        co.setTopicId(id)
        List<Topic> topic = Topic.search(co).list()
        log.info("${topic}")
//        render("${topic} ${id} ${co.topicId} ${topic[0]}")
        if (!topic) {
            flash.error = "NO SUCH TOPIC"
//            render("${params}")
            redirect(controller: 'logIn', action: 'index')
        }
        else {
                if(topic[0].visibility == Visibility.PUBLIC){
                    render("success ${topic[0].toString()}")
                }
                else if(topic[0].visibility == Visibility.PRIVATE){
                    Subscription subscription = Subscription.findByUserAndTopic(session.user,topic1)
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
        topic.delete(flush:true)
        render("Topic Deleted Successfully")
    }

    def save(String topic,String visibility){
//        HttpSession session = request.getSession()
//        User user = session.getAttribute(uname)
//        println(params)
//        User user =User.findByFirstName("sankalp")
        Topic topic1 = new Topic(name: topic,createdBy: session.user,visibility: Visibility.isVisibility(visibility))
        if(topic1.validate()){
            topic1.save(flush:true)
            flash.message = "Topic is saved ${topic1}"
            render("Topic saved Successfully")
        }
        else {
            flash.error = "topic not saved"
            render("Error while saving topic ${topic1} ${topic1.errors.allErrors}")
        }
    }


    /*def demo1(ResourceSearchCO co,Long id){
//        ResourceSearchCO co = new ResourceSearchCO(topicId: id)
        co.setTopicId(id)
        List resource = Resource.search(co).list()
        println(resource)
        render("${resource} ${co.topicId}")
    }*/
}
