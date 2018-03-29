package linksharingapp

import enumeration.Seriousness

class Subscription {
    Topic topic
    User user
    Date dateCreated
    Seriousness seriousness

    Subscription(Topic topic, User user, Seriousness seriousness) {
        this.topic = topic
        this.user = user
        this.seriousness = seriousness
    }
    static constraints = {
        user(nullable: false,unique: 'topic')
        topic(nullable: false)
        seriousness(nullable: false)
    }

}
