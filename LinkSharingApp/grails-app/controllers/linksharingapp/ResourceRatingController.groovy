package linksharingapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ResourceRatingController {


    def index() { }


    def save() {
        if (session.userId){
            User user = User.findById(session.userId.toLong())
            Resource resource = Resource.findById(params.id.toLong())
            Integer score = new Integer(params.rating)
            if (ResourceRating.findByUserAndResource(user,resource)){
                flash.error = "${user.name}, you already voted this resource"
                redirect(controller: 'logIn',action: 'index')
            }
            else {
                ResourceRating resourceRating = new ResourceRating(user: user,resource: resource,score: score)
                resourceRating.save()
                redirect(controller: 'logIn',action: 'index')
            }
        }
        else {
            flash.error = "Please LogIn to vote"
            redirect(controller : 'logIn' , action : 'index')
        }
    }
}
