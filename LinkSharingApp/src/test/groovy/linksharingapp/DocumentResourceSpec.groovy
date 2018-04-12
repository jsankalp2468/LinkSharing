package linksharingapp

import enumeration.Visibility
import grails.testing.gorm.DomainUnitTest
import org.junit.Ignore
import password.ConstantPassword
import spock.lang.Specification

@Ignore
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

    void "validating toString()"(){
        setup:
        String email = "sankal.jain@tothenew.com"
        String password = ConstantPassword.userPassword
//        User user = new User(email: email,userName:"jsankalp",password:password, firstName: "sankalp", lastName: "jain",admin:false,active:true)
//        Topic topic = new Topic('name': "my1",'createdBy': user,'visibility': Visibility.PRIVATE)
            User user = Mock(User)
            Topic topic = Mock(Topic)
        when:
        DocumentResource documentResource = new DocumentResource(createdBy: user,topic: topic,description: "hello",filePath: "filePath")
        documentResource.save(deepValidate :false)

        then:
        documentResource.toString() == "DocumentResource{filePath='${documentResource.filePath}'}"
    }
}
