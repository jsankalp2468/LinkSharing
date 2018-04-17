package linksharingapp

import co.ResourceSearchCO
import dto.EmailDTO
import enumeration.Visibility

import javax.servlet.http.HttpSession


class TopicController {

    def userService
    def sendMailService
    def topicService

    def index() {
            Resource resource = Resource.findById(params.id)
            Topic topic = Topic.findById(resource.topic.id)
//        Topic topic = Topic.findById(params.id.toLong())
//        Resource resources = Resource.findByTopic(topic)
        println("id")
        render(view: 'index', model: [subscribedUsers: topic.getSubscribedUsers(), resources: topic.resources, topic: topic])
    }


    def show() {
        ResourceSearchCO co = new ResourceSearchCO()
        if (params.id) {
            Long l = new Long(params.id)
            co.setTopicId(l)
        } else if (params.name) {
            Topic topic1 = Topic.findByName(params.name)
            co.setTopicId(topic1.id)
            println(topic1)
        }
        List<Topic> topic = Topic.search(co).list()
        log.info("${topic}")
        if (!topic) {
            flash.error = "NO SUCH TOPIC"
//            render("${params}")
            redirect(controller: 'logIn', action: 'index')
        } else {
            if (topic[0].visibility == Visibility.PUBLIC) {
                render(view: 'index', model: [subscribedUsers: topic[0].getSubscribedUsers(), resources: topic[0].resources])
            } else if (topic[0].visibility == Visibility.PRIVATE) {
                User user = User.findById(session.userId.toLong())
                Subscription subscription = Subscription.findByUserAndTopic(user, topic)
                if (subscription) {
                    render("succcess")
                } else {
                    flash.error = "Please LogIn to Continue!!"
                    redirect(controller: 'logIn', action: 'index')
                }
            }

        }
    }

    def delete(Long id) {
        Topic topic = Topic.load(id)
        List<Resource> resources = Resource.findAllByTopic(topic)
        println(resources)
        Subscription.executeUpdate("delete from Subscription where topic_id=:id", [id: topic.id])
        resources.each { Resource resource ->
            ResourceRating.executeUpdate("delete from ResourceRating where resource_id=:id", [id: resource.id])
            ReadingItem.executeUpdate("delete from ReadingItem where resource_id=:id", [id: resource.id])
            Resource.executeUpdate("delete from Resource where id=:id", [id: resource.id])

        }
        topic.executeUpdate("delete from Topic where id=:id", [id: id])
        flash.message = "Topic Deleted Successfully"
        redirect(controller: 'user',action: 'index')
    }

    def save(String topic, String visibility) {
//        User user =User.findByFirstName("sankalp")
        User user = userService.findUserFromUserId(session.userId)
        if (user) {
            println(visibility)
            Topic topic1 = new Topic(name: topic, createdBy: user, visibility: Visibility.isVisibility(visibility))
            if (topic1.validate()) {
                topic1.save(flush: true)
                flash.message = "Topic is saved ${topic1}"
//                render("Topic saved Successfully")
                redirect(controller: 'logIn', action: 'index')
            } else {
                flash.error = "topic not saved"
//            render("Error while saving topic ${topic1} ${topic1.errors.allErrors}")
                redirect(controller: 'logIn', action: 'index')
            }
        } else {
            redirect(controller: 'logIn', action: 'index')
        }
    }

    def invite() {
        Topic topic1 = Topic.findById(params.topicId)

        if (topic1 && User.findByEmail(params.email1)) {

            EmailDTO emailDTO = new EmailDTO(to: params.email1, subject: "INVITATION", from: "linksharing1@gmail.com", linkId: topic1.id, content: "Please subscribe for the Topic")

            sendMailService.sendInvitation(emailDTO)
            flash.message = "Invitation Send"
            redirect(controller: 'user', action: 'index')


        } else {
            flash.error = "Error while inviting user"
            redirect(controller: 'user', action: 'index')
        }
    }

    /*def demo1(ResourceSearchCO co,Long id){
//        ResourceSearchCO co = new ResourceSearchCO(topicId: id)
        co.setTopicId(id)
        List resource = Resource.search(co).list()
        println(resource)
        render("${resource} ${co.topicId}")
    }*/

    def showSubscribedUsers() {
        Topic topic = Topic.findById(1)
        render(view: 'showSubscribedUsers', model: [userList: topic.getSubscribedUsers()])
    }

    def changeIsReadToFalse() {
        User user = userService.findUserFromUserId(session.userId)
        topicService.changeIsReadToFalse(user, params.id.toLong())
        flash.message = "Resource removed from inbox successfully!!"
        redirect(controller: 'user', action: 'index')
    }

    def changeIsReadToTrue() {
        User user = userService.findUserFromUserId(session.userId)
        topicService.changeIsReadToTrue(user, params.id.toLong())
        flash.message = "Resource added to inbox successfully!!"
        redirect(controller: 'user', action: 'index')
    }
}
