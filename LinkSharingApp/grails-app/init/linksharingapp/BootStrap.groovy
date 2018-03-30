package linksharingapp

import enumeration.Seriousness
import enumeration.Visibility
import grails.util.Holders
import password.ConstantPassword

class BootStrap {

    def init = { servletContext ->
        println("**************************************************")
        println(Holders.grailsApplication.config.server.contextPath)
//        demo()
        if(User.count()==0){createUsers()}
        createTopic()
    }
    def destroy = {
    }


    void createUsers(){
        User admin = new User()
        admin.setFirstName("Sankalp")
        admin.setLastName("Jain")
        admin.setEmail("sankalp.jain@tothenew.com")
        admin.setUserName("jsankalp")
        admin.setPassword(ConstantPassword.userPassword)
//        admin.setPhoto(null)
        admin.setAdmin(true)
        admin.setActive(true)

        if(admin.validate()){
            println(admin.save(failOnError : true,flush : true))
        }
        log.info("Admin is valid- ${admin.validate()}")
        log.info("Admin has errors while validating- ${admin.hasErrors()}")

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

        log.info("User is valid- ${user.validate()}")
        log.info("User has errors while validating- ${user.hasErrors()}")

    }

    void createTopic(){
        List<User> allUsers = User.findAll()
        allUsers.each {
            if(!it.topics){
                User temp = it
                5.times {
                    Topic topic = new Topic("mytopic${it}",temp,Visibility.PUBLIC)
                    if(topic.validate()){log.info("Topic saved successfully - ${temp.addToTopics(topic)}")}
                    else {
                        log.info("Topic has errors while saving -${topic.hasErrors()}")
                    }
                }
            }
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


