package linksharingapp

import grails.artefact.Controller

import javax.servlet.http.HttpSession

class LogInController {

    def index() {
        HttpSession session = request.getSession()
        if(session.getAttribute('user')){
//            render("login index")
            forward(controller: 'user',action: 'index')
        }
        else {
            render("User not exists")
        }
    }

    def logInHandler() {
        HttpSession session = request.getSession()
        String userName = params.userName
        String password = params.password
//        render("${userName}  ${password}")
        User user = User.findByUserNameAndPassword(userName,password)
        if (user){
            if(user.active){
                session.setAttribute('user',user)
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
        HttpSession session = request.getSession()
        session.invalidate()
        forward(controller : 'logIn', action :'index')
    }
}
