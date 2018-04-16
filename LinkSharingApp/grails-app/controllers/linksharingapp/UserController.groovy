package linksharingapp

import co.ForgotPasswordCO
import co.SearchCO
import vo.TopicVO

class UserController {

    def readingItemService

    def index() {
        println(session.userId)
        if (session.userId) {
            User user = User.findById(session.userId.toLong())
            def max = params.max ?: 5
            def offset = params.offset ?: 0
//            Set<ReadingItem> unReadItems = ReadingItem.findAllByUser(user,[max:max,offset:offset])
            def unReadItems = readingItemService.findReadingItemsForAUser(user, max, offset)
            render(view: 'index', model: [unReadItems: unReadItems, total: unReadItems.totalCount])
        } else {
            redirect(controller: 'logIn', action: 'index')
        }
    }

    def show() {
        SearchCO searchCO = new SearchCO()
        searchCO.setQ("topic")
        searchCO.setMax(5)
        searchCO.setOffset(0)
        render("${User.getUnReadResources(searchCO)}")

    }

    def showTrendingTopics() {
        List<TopicVO> topicVOList = Topic.getTrendingTopics()
        render("${topicVOList}")
    }

    def showSubscribedTopics() {
        if (session.userId) {
            User user = User.findById(session.userId.toLong())
            render(view: 'showSubscribedTopics', model: [topicList: user.getSubscribedTopics()])
        } else {
            redirect(controller: 'logIn', action: 'index')
        }
    }

    def editProfile() {
        render(view: 'editProfile')
    }

    def changePassword(ForgotPasswordCO co) {
        User user = User.findByIdAndPassword(session.userId.toLong(), co.oldPassword)
        if (user) {
            user.password = co.newPassword
            user.confirmPassword = co.confirmPassword
            if (user.validate()) {
                user.save(flush: true)
                flash.message = "Password changed successfully!!"
                redirect(controller: 'user', action: 'index')
            } else {
                flash.error = "Error while saving password"
                render(view: 'editProfile')
            }
        } else {
            flash.error = "Password not matched"
            render(view: 'editProfile')
        }
    }


    def updateProfile() {
        User user = User.findById(session.userId.toLong())
//        println(user)
        def file = new File("/home/sankalp/Desktop/PP/${user.userName}.jpg")
        user.firstName = params.firstName
        user.lastName = params.lastName
        user.userName = params.userName
        user.confirmPassword = user.password
//        println(user)
        if (user.validate()){
            user.save(flush:true)
            if (file) {
                file.delete()
            }
            def avatar = request.getFile('avatar')
            avatar.transferTo(new java.io.File("/home/sankalp/Desktop/PP/${params.userName}.jpg"))
            flash.message = "Profile Pic changed Successfully"
        }else{
            flash.error = "Error while updating profile"
            println(user.errors.allErrors)
        }
        redirect(controller: 'user', action: 'index')
    }

//    def list(){
//        User user = User.findById(session.userId.toLong())
//        [users:User.list(params) , userCount:User.count()]
//    }
}