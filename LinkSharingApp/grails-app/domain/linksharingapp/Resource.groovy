package linksharingapp

abstract class Resource {

    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated
    //createdBy description topic already created.

    static constraints = {
        description(type: 'text')
    }
}
