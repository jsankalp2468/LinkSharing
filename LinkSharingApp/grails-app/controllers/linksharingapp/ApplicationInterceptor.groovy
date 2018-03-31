package linksharingapp


import grails.interceptors.Matcher
import org.springframework.context.event.ApplicationEventMulticaster


class ApplicationInterceptor {

    public ApplicationInterceptor(){
        matchAll()
    }


    boolean before() {
        log.info("from before of ApplicationInterceptor. Params : ${params}")
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
