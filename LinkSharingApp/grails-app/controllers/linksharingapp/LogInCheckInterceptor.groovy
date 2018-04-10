package linksharingapp

import javax.servlet.http.HttpSession


class LogInCheckInterceptor {

    public LogInCheckInterceptor(){
        matchAll().excludes(controller : 'logIn')
    }

    boolean before() {
//        HttpSession session = request.getSession()
//        log.info(" from logincheckinterceptor")
//        if(!session.userId){
//            redirect(controller: 'logIn', action: 'index')
//            false
//        }
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
