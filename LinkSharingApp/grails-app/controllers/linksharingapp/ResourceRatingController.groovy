package linksharingapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ResourceRatingController {

    def userService

    def index() { }


    def save() {
        if (session.userId){
            User user = userService.findUserFromUserId(session.userId)
            Resource resource = Resource.findById(params.id.toLong())
            user.confirmPassword = user.password
            println(user.name)
            println(resource.id)
//            Integer score = new Integer(params.rating)
            println(ResourceRating.findByUserAndResource(user,resource))
            ResourceRating resourceRating1 = ResourceRating.findByUserAndResource(user,resource)
            if (resourceRating1){
                flash.error = "${user.name}, you already voted this resource"
                redirect(controller: 'logIn',action: 'index')
            }
            else {
                flash.message = "Rating given"
                ResourceRating resourceRating = new ResourceRating(user: user,resource: resource,score: params.int('rating'))
                println(resourceRating.save(flush:true))
                println(resourceRating.errors.allErrors)
                redirect(controller: 'logIn',action: 'index')
            }
        }
        else {
            flash.error = "Please LogIn to vote"
            redirect(controller : 'logIn' , action : 'index')
        }
    }
}
