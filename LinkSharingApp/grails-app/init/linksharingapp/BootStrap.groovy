package linksharingapp

import enumeration.Seriousness
import enumeration.Visibility
import grails.util.Holders

class BootStrap {

    def init = { servletContext ->
        println("**************************************************")
        println(Holders.grailsApplication.config.server.contextPath)
//        demo()
        createUsers()
    }
    def destroy = {
    }


    void createUsers(){
        User admin = new User()
        admin.setFirstName("Sankalp")
        admin.setLastName("Jain")
        admin.setEmail("sankalp.jain@tothenew.com")
        admin.setUserName("jsankalp")
        admin.setPassword("abcdef")
//        admin.setPhoto(null)
        admin.setAdmin(true)
        admin.setActive(true)

        if(admin.validate()){
            println(admin.save(failOnError : true,flush : true))
        }

        User user = new User()
        user.setFirstName("Neelesh")
        user.setLastName("Bansal")
        user.setEmail("neelesh.bansal@tothenew.com")
        user.setUserName("neelesh")
        user.setPassword("12345")
//        user.setPhoto(null)
        user.setAdmin(false)
        user.setActive(true)

        if (user.validate()){
            println(user.save(failOnError : true , flush: true))
        }
    }

    void demo(){
        User user2 = new User(firstName: "neelesh",lastName: "bansal",email: "neelesh@ttn.com",userName: "neelesh",password: "abcdef",photo: 1,admin: true,active: null)
        Topic topic2= new Topic(name: "mytopic2",createdBy: user2,visibility: Visibility.PRIVATE)
        User user1 = new User(firstName: "sankalp",lastName: "jain",email: "sankalp.jain@ttn.com",userName: "jsankalp",password: "abcdef",photo: 1,admin: true,active: null)
        Topic topic1= new Topic(name: "mytopic1",createdBy: user1,visibility: Visibility.PRIVATE)
        Resource resource = new LinkResource(createdBy: user1, description: "njkasjks",topic:topic1 , url: "https://www.google.com")
        ResourceRating resourceRating = new ResourceRating(resource: resource,user: user1,score: 3)
        println(resourceRating.save())
        ResourceRating resourceRating2 = new ResourceRating(resource: resource,user: user2,score: 4)
        println(resourceRating2.save())
    }
}


