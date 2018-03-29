package linksharingapp

class ReadingItem {

    Resource resource
    User user
    Boolean isRead

    static constraints = {
        isRead(nullable: false)
        user(nullable: false)
        resource(unique: 'user')
    }
}
