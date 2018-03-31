package linksharingapp

class UserController {

    def index() {
        render("User Dashboard ${session.user.userName}")
    }
}
