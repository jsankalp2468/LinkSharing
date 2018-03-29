package linksharingapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DocumentResourceSpec extends Specification implements DomainUnitTest<DocumentResource> {

    def setup() {
    }

    def cleanup() {
    }

    void "testing filePath field"(){
        when:
        DocumentResource documentResource = new DocumentResource(filePath: "/home/sankalp")
        boolean result = documentResource.validate()

        then:
        result == true
    }

    void "testing filePath field to null"(){
        when:
        DocumentResource documentResource = new DocumentResource(filePath: "")
        boolean result = documentResource.validate()

        then:
        result == false
    }
}
