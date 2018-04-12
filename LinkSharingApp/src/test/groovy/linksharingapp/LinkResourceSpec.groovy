package linksharingapp

import enumeration.Visibility
import grails.testing.gorm.DomainUnitTest
import org.junit.Ignore
import password.ConstantPassword
import spock.lang.Specification

@Ignore
class LinkResourceSpec extends Specification implements DomainUnitTest<LinkResource> {

    def setup() {
    }

    def cleanup() {
    }

    @Ignore
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

    @Ignore
    void "validating toString()"(){
        setup:
        String email = "sankal.jain@tothenew.com"
        String password = ConstantPassword.userPassword
        User user = new User(email: email,userName:"jsankalp",password:password, firstName: "sankalp", lastName: "jain",admin:false,active:true)
        Topic topic = new Topic('name': "my1",'createdBy': user,'visibility': Visibility.PRIVATE)

        when:
        LinkResource linkResource = new LinkResource(createdBy: user,topic: topic,url: "https://www.google.co.in")
        then:
        documentResource.toString() == "DocumentResource{filePath='${documentResource.filePath}'}"
    }
}
