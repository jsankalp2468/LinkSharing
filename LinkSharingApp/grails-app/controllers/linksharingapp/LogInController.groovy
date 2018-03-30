package linksharingapp

import grails.artefact.Controller

class LogInController {

    def index() {
        if(session.user){
//            render("login index")
            forward(controller: 'user',action: 'index')
        }
        else {
            render("User not exists")
        }
    }

    def logInHandler() { }

    def logOut() {
        session.invalidate()
        forward(controller : 'logIn', action :'index')
    }
}
