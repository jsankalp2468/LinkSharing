package linksharingapp

abstract class Resource {

    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated
    //createdBy description topic already created
    static belongsTo = [createdBy:User,topic:Topic]
    static hasMany = [ratings:ResourceRating, readingItems:ReadingItem]
    static constraints = {
        description(type: "text")
    }
}
