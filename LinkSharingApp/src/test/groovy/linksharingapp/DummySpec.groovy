package linksharingapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DummySpec extends Specification implements DomainUnitTest<Dummy> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
