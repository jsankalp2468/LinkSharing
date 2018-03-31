package linksharingapp

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

import javax.servlet.http.HttpSession

class UserControllerSpec extends Specification implements ControllerUnitTest<UserController> {

    def setup() {
    }

    def cleanup() {
    }

    //test case not working
    /*void "testing index"(){
        setup:
        HttpSession session = request.getSession()
        session.setAttribute('user',new User('san','jan','as.as@sss.com','jsankalp','asdfgg'))

        when:
        controller.index()

        then:
        response.text == "User Dashboard jsankalp"
    }*/
}
