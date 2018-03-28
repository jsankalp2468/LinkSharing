package User

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserSpec extends Specification implements DomainUnitTest<User> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    void "validating user with every possible constraints"(){
        setup:
        User user = new User(firstName: fname,lastName: lname,email: email,userName: uname,password: pswd,photo: photo,admin: admin,active: active)
        when:
        Boolean result = user.validate()
        then:
        result == value

        where:
        fname       | lname     | email                         | uname     | pswd      | photo | admin | active | value
        "sankalp"   |"jain"     |"sankalp.jain@tothenew.com"    |"jsankalp" | "abcdef"  | 1     | true  | true   |  true
        //Email constraints
        "sankalp"   |"jain"     |"sankalp.jain@to"              |"jsankalp" | "abcdef"  | 1     | true  | true   |  false
        "sankalp"   |"jain"     |  null                         |"jsankalp" | "abcdef"  | 1     | true  | true   |  false
        "sankalp"   |"jain"     |""                             |"jsankalp" | "abcdef"  | 1     | true  | true   |  false
        //password constraints
        "sankalp"   |"jain"     |"sankalp.jain@tothenew.com"    |"jsankalp" | null      | 1     | true  | true   |  false
        "sankalp"   |"jain"     |"sankalp.jain@tothenew.com"    |"jsankalp" | "abcd"    | 1     | true  | true   |  false
        "sankalp"   |"jain"     |"sankalp.jain@tothenew.com"    |"jsankalp" | ""        | 1     | true  | true   |  false
        //firstname constraints
        null        |"jain"     |"sankalp.jain@tothenew.com"    |"jsankalp" | "abcdef"  | 1     | true  | true   |  false
        ""          |"jain"     |"sankalp.jain@tothenew.com"    |"jsankalp" | "abcdef"  | 1     | true  | true   |  false
        //lastname constraints
        "sankalp"   |null       |"sankalp.jain@tothenew.com"    |"jsankalp" | "abcdef"  | 1     | true  | true   |  false
        "sankalp"   |""         |"sankalp.jain@tothenew.com"    |"jsankalp" | "abcdef"  | 1     | true  | true   |  false
        //photo constraint
        "sankalp"   |"jain"     |"sankalp.jain@tothenew.com"    |"jsankalp" | "abcdef"  | 0     | true  | true   |  true
        //admin constraint
        "sankalp"   |"jain"     |"sankalp.jain@tothenew.com"    |"jsankalp" | "abcdef"  | 0     | null  | true   |  true
//        active constraint
        "sankalp"   |"jain"     |"sankalp.jain@tothenew.com"    |"jsankalp" | "abcdef"  | 0     | true  | null   |  true
    }

    void "validating uniqueness of email"(){
        setup:
        String email = "sankalp.jain@tothenew.com"

        when:
        User user1 = new User(firstName: "sankalp",lastName: "jain",email: email,userName: "jsank",password: "abcdef",photo: 1,admin: true,active: null)
        user1.save()

        then:
        user1.count() == 1

        when:
        User user2 = new User(firstName: "neelesh",lastName: "bansal",email: email,userName: "neelesh",password: "abcdef",photo: 1,admin: true,active: null)
        user2.save()

        then:
        user2.count() == 1
        user2.errors.allErrors.size() == 1
        user2.errors.getFieldErrorCount('email') == 1
    }

    void "validating uniqueness of username"(){
        setup:
        String uname = "jsankalp"

        when:
        User user1 = new User(firstName: "sankalp",lastName: "jain",email: "sankalp.jain@ttn.com",userName: uname,password: "abcdef",photo: 1,admin: true,active: null)
        user1.save()

        then:
        user1.count() == 1

        when:
        User user2 = new User(firstName: "neelesh",lastName: "bansal",email: "neelesh.bansal@ttn.com",userName: uname,password: "abcdef",photo: 1,admin: true,active: null)
        user2.save()

        then:
        user2.count() == 1
        user2.errors.allErrors.size() == 1
        user2.errors.getFieldErrorCount('userName') == 1
    }
}
