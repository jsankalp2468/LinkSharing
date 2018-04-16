package linksharingapp

import co.LogInCO
import dto.EmailDTO
import grails.artefact.Controller
import password.GeneratePassword
import vo.TopPostVO

import javax.servlet.http.HttpSession

class LogInController {
    def sendMailService
    def index() {
        HttpSession session = request.getSession()
        if(session.getAttribute('userId')){
            forward(controller: 'user',action: 'index')
        }
        else {
            render(view: 'index',model: [topPostFilter: params.topPostFilter])
        }
    }

    def logInHandler(LogInCO co) {
        HttpSession session = request.getSession()
        String userName = co.userName
        String password = co.password
        User user = User.findByUserNameAndPassword(userName,password)
        if (user){
//            session.user = user.id
            session.setAttribute('userId',user.id)
            if(user.active){
//                session.setAttribute('user',user)
                redirect(controller: "user", action: 'index')
            }
            else {
                flash.error = "User is not active"
                redirect(controller: 'logIn',action: 'index')
            }
        }
        else {
            flash.error ="User not found"
            redirect(controller: 'logIn',action: 'index')
        }
    }

    def logOut() {
        session.invalidate()
        forward(controller : 'logIn', action :'index')
    }

    def register() {
        User user = new User(firstName: params.firstName, lastName: params.lastName, email: params.email,
                    userName: params.userName , password: params.password,confirmPassword: params.confirmPassword)
        user.active = true
        if(user.validate()){
            user.save(flush:true)
            def avatar = request.getFile('avatar')
            avatar.transferTo(new java.io.File("/home/sankalp/Desktop/PP/${params.userName}.jpg"))
//            render("success")
            session.userId = user.id
            redirect(controller: 'logIn',action: 'index')
        }else {
//            redirect(controller: 'logIn',action: 'index')
            flash.error = "User not registered"
            render(view: 'index',model: [user:user])
        }
//
    }

    def showTopTopics() {
        List<TopPostVO> topPostVOList = Resource.getTopPosts()
        render(view: 'showTopTopics',model: [lists:topPostVOList])
    }

    def show(){
        def file = new File("/home/sankalp/Desktop/PP/${params.name}.jpg")
        def img = file.bytes
        response.contentType = '*' // or the appropriate image content type
        response.outputStream << img
        response.outputStream.flush()
    }

    def sendMailWhenForgotPassword(){

        User user = User.findByEmailAndUserName(params.email1, params.userName1)
        println(user)
        if (user) {
            def newPassword = GeneratePassword.randomPassword
            String pass=newPassword
            println(pass)




            EmailDTO emailDTO = new EmailDTO(to: params.email1, subject: "Password Reset", from: "linksharing1@gmail.com", content: "Your new password is : ${newPassword}")
            sendMailService.sendMail1(emailDTO)


            User.executeUpdate("update User set password=:password where id=:id", [password: pass, id: user.id])
            println("Inside password changing mode 3")
            flash.message = "Mail sent successlly"
            redirect(action: 'index')
        } else {
            flash.error = "Mail not sent please check username and email"
            redirect(action: 'index')
        }
    }
}
