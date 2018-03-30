package linksharingapp

import enumeration.Visibility
import grails.testing.gorm.DomainUnitTest
import password.ConstantPassword
import spock.lang.Specification
import linksharingapp.User

class TopicSpec extends Specification implements DomainUnitTest<Topic> {

    def setup() {
    }

    def cleanup() {
    }



    void "Testing all constraints"(){

        setup:
        User user1 = new User(firstName: "sankalp",lastName: "jain",email: "sankalp.jain@ttn.com",userName: "jsank",password: "abcdef",photo: 1,admin: true,active: null)
        Topic topic1 = new Topic(name: name1,createdBy: user1,visibility: visibility)
        when:
        boolean result = topic1.validate()

        then:
        result == value

        where:
        name1       | visibility        |value

        "mytopic1"  | Visibility.PUBLIC |true

        //name constraints
        null        |Visibility.PUBLIC  |false
        ""          |Visibility.PUBLIC  |false

        //visibility constraints
        "mytopic1"  | null              |false
    }

    void "Unique Topic per user Validation"(){
        setup:
        User user1 = new User(firstName: "sankalp",lastName: "jain",email: "sankalp.jain@ttn.com",userName: "jsank",password: "abcdef",photo: 1,admin: true,active: null)
        when:
        Topic topic1 = new Topic(name: "mytopic1",createdBy: user1,visibility: Visibility.PUBLIC)
        topic1.save()
        then:
        topic1.count() == 1

        when:
        Topic topic2 = new Topic(name: "mytopic1",createdBy: user1,visibility: Visibility.PRIVATE)
        topic2.save()
        then:
        topic2.count() == 1
        topic2.errors.allErrors.size() == 1
        topic2.errors.getFieldErrorCount('name') == 1

    }

    def "validating toString "(){

        setup:
        String email = "sankal.jain@tothenew.com"
        String password = ConstantPassword.userPassword
        User user = new User(email: email,userName:"jsankalp",password:password, firstName: "sankalp", lastName: "jain",admin:false,active:true)
        Topic topic = new Topic('name': "my1",'createdBy': user,'visibility': Visibility.PRIVATE)

        when:
        topic.save()

        then:
        topic.toString() == "Topic{name='${topic.name}'}"
    }



}
