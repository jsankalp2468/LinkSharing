package linksharingapp

import enumeration.Visibility
import grails.testing.gorm.DomainUnitTest
import org.junit.Ignore
import spock.lang.Specification

@Ignore
class ResourceRatingSpec extends Specification implements DomainUnitTest<ResourceRating> {

    def setup() {
    }

    def cleanup() {
    }

    void "testing"(){
        setup:
        User user2 = new User(firstName: "neelesh",lastName: "bansal",email: "neelesh@ttn.com",userName: "neelesh",password: "abcdef",confirmPassword: "neelesh")
        Topic topic2= new Topic( "mytopic2",user2,Visibility.PRIVATE)
        User user1 = new User(firstName: "sankalp",lastName: "jain",email: "sankalp.jain@ttn.com",userName: "jsankalp",password: "abcdef",confirmPassword: "abcdef")
        Topic topic1= new Topic("mytopic1",user1,Visibility.PRIVATE)
        Resource resource = new LinkResource(createdBy: user1, description: "njkasjks",topic:topic1 , url: "https://www.google.com")

        when:
        ResourceRating resourceRating = new ResourceRating(resource: resource,user: user1,score: 3)
        boolean  b =resourceRating.validate()

        then:
        b == true

        when:
        ResourceRating resourceRating2 = new ResourceRating(resource: resource,user: user1,score: 4)
        b = resourceRating2.validate()

        then:
        b==false

    }
}
