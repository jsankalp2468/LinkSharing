package linksharingapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class LinkResourceSpec extends Specification implements DomainUnitTest<LinkResource> {

    def setup() {
    }

    def cleanup() {
    }

    void "validating correct string form"(){
        when:
        LinkResource linkResource = new LinkResource(url: url1)
        boolean result = linkResource.validate()

        then:
        result == valid

        where:

        url1                        | valid
        "https://www.google.co.in"  | true
        "http://www.google.co.in"   | true
        "ftp://www.google.co.in"    | true
        "http://ww.google.com"      | true
        "https://www.google"        | true
        "https://google.com"        | true
        ""                          | false
        "http//www.google.com"      | false
        "http/www.google.com"       | false
        "google.com"                | false

    }
}
