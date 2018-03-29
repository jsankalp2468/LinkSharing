package linksharingapp

class ResourceRating {

    Resource resource
    User user
    Integer score

    static constraints = {
        resource(nullable: false,unique: 'user')
        user(nullable: false)
        score(nullable: false,min:3 , max:5)
    }
}
