package linksharingapp

import enumeration.Visibility

class Topic {

    String name
    User createdBy
    Date dateCreated
    Date lastUpdated
    Visibility visibility

    static belongsTo = [createdBy:User]
    static hasMany = [subscriptions:Subscription,resources:Resource]

    Topic(String name, User createdBy, Visibility visibility) {
        this.name = name
        this.createdBy = createdBy
        this.visibility = visibility
    }
    static constraints = {
        name(nullable: false,blank: false,unique: 'createdBy')
        visibility(nullable: false)
        createdBy(nullable: false)
    }
}
