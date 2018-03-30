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

    def logInHandler() {
        String userName = params.userName
        String password = params.password
//        render("${userName}  ${password}")
        User user = User.findByUserNameAndPassword(userName,password)
        if (user){
            if(user.active){
                session.user = user
                redirect(controller: "logIn", action: 'index')
            }
            else {
                flash.error = "User is not active"
                render("User not active")
            }
        }
        else {
            flash.error ="User not found"
            render("${flash.error}")
        }
    }

    def logOut() {
        session.invalidate()
        forward(controller : 'logIn', action :'index')
    }
}
