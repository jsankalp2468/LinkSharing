package linksharingapp

class ReadingItem {

    Resource resource
    User user
    Boolean isRead
    Date dateCreated
    Date lastUpdated

    static constraints = {
        isRead(nullable: false)
        user(nullable: false)
        resource(unique: 'user')
    }
}
