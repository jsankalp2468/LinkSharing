package linksharingapp

import enumeration.Seriousness
import enumeration.Visibility

class Topic {

    String name
    User createdBy
    Date dateCreated
    Date lastUpdated
    Visibility visibility
    List resources

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

    def afterInsert(){
        Topic.withNewSession {
            Subscription subscription = new Subscription(this,this.createdBy,Seriousness.VERY_SERIOUS)
            if (subscription.save(flush:true)){
                log.info("Subscription saved successfully - ${this.addToSubscriptions(subscription)}")
            }
            else {
                log.info("Subscription has errord while saving - ${subscription.hasErrors()}")
            }
        }
    }
}
