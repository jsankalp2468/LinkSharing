package linksharingapp

import enumeration.Seriousness
import enumeration.Visibility
import grails.util.Holders

class BootStrap {

    def init = { servletContext ->
        println("**************************************************")
        println(Holders.grailsApplication.config.server.contextPath)
        demo()
    }
    def destroy = {
    }

    void demo(){

        User user1 = new User(firstName: "sankalp",lastName: "jain",email: "sankalp.jain@ttn.com",userName: "jsank",password: "abcdef",photo: 1,admin: true,active: null)
        Topic topic1 = new Topic(name: "myTopic1",createdBy: user1,visibility: Visibility.PRIVATE)
        Subscription subscription = new Subscription(topic1,user1,Seriousness.CASUAL)
        println(subscription.save())
    }
}


