package linksharingapp

import co.SearchCO

class UserController {

    def index() {
//        render("User Dashboard ${session.user.password}")
        render(view: 'index')
    }

    def show(){
        SearchCO searchCO = new SearchCO()
        searchCO.setQ("topic")
        searchCO.setMax(5)
        searchCO.setOffset(0)
        render("${User.getUnReadResources(searchCO)}")

    }
}
