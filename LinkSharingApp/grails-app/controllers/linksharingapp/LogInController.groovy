package linksharingapp

import grails.artefact.Controller
import vo.TopPostVO

import javax.servlet.http.HttpSession

class LogInController {


    def index() {
        HttpSession session = request.getSession()
//        render(view: 'index')
        if(session.getAttribute('user')){
//            render("login index")
            forward(controller: 'user',action: 'index')
        }
        else {
            List<TopPostVO> topPostVOList = Resource.getTopPosts()
            render(view: 'index',model: [lists: topPostVOList])
        }
    }

    def logInHandler() {
        HttpSession session = request.getSession()
        String userName = params.userName
        String password = params.password
//        render("${userName}  ${password}")
        User user = User.findByUserNameAndPassword(userName,password)
        println(user)
        println(userName)
        println(password)
        if (user){
            session.user = user
//            session.getAttribute('user')
            if(user.active){
                session.setAttribute('user',user)
                redirect(controller: "user", action: 'index')
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

    def register() {
        User user = new User(firstName: params.firstName, lastName: params.lastName, email: params.email,
                    userName: params.userName , password: params.password,confirmPassword: params.confirmPassword)
        if(user.validate()){
            log.info("User registered successfully! ${user.save(flush:true, failOnError : true)}")
            render("Success")
        }
        else {
            flash.message = "flash message is set"
            def msg = message(code: 'usernotsaved',null)
            render(msg)
        }
    }

    def showTopTopics() {
        List<TopPostVO> topPostVOList = Resource.getTopPosts()
        render(view: 'showTopTopics',model: [lists:topPostVOList])
//        render(view:  "showTopTopics")
    }
}
