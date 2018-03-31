package linksharingapp


class LogInCheckInterceptor {

    public LogInController(){
        matchAll().excludes(controller : 'logIn')
    }

    boolean before() {
        log.info(" from logincheckinterceptor")
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
