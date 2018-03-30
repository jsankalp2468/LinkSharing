package linksharingapp

import grails.artefact.Controller

class LogInController {

    def index() {
        if(session){
            forward(controller: 'user',action: 'index')
        }
        else {
            render("User not exists")
        }
    }

    def logInHandler() { }

    def logOut() { }
}
