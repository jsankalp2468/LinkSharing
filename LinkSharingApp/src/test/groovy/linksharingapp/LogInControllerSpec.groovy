package linksharingapp

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class LogInControllerSpec extends Specification implements ControllerUnitTest<LogInController> {

    def setup() {
    }

    def cleanup() {
    }

    def "testing true session.user case of index"(){
        when:
        controller.index()

        then:
        response.text == 'User not exists'
    }
    def "testing false session.user case of index"(){
        when:
        session.user = "sankalp"
        controller.index()

        then:
        response.forwardedUrl == '/user/index'
    }

    def "testing logout"(){
        when:
        controller.logOut()

        then:
        // '/login/index is not validating because we changed mgging in URLmapping in previous ques.
        response.forwardedUrl == '/'
    }

    def "testing logInHandler when user is found "(){
        setup:


        when:
        controller.logInHandler()

        then:
        response.forwardedUrl == '/'
    }
}
