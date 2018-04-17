package linksharingapp


import grails.interceptors.Matcher
import org.springframework.context.event.ApplicationEventMulticaster

import javax.servlet.http.HttpSession


class ApplicationInterceptor {

    public ApplicationInterceptor(){
        matchAll().excludes(controller: SubscriptionController)
    }


    boolean before() {
        HttpSession session = request.getSession()
        log.info("from before of ApplicationInterceptor. Params : ${params}")
        if(!session.user){
            true
        }
        else {
            true
        }
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
