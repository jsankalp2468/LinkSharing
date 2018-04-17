package linksharingapp

import enumeration.Seriousness
import grails.gorm.transactions.Transactional

@Transactional
class SubscriptionService {
    def userService
    def subscribe(Long id,def userId){
        Topic topic = Topic.findById(id)
        User user = userService.findUserFromUserId(userId)
        user.confirmPassword = user.password
        Subscription subscription = new Subscription(topic: topic,user: user,seriousness: Seriousness.VERY_SERIOUS)
        subscription.save(flush : true)
        List<Resource> resource = Resource.findAllByTopic(topic)
        println(resource)
        resource.each {
            ReadingItem readingItem = new ReadingItem(resource: it,user: user,isRead: false)
            readingItem.save(flush:true,failOnError:true)
            user.addToReadingItems(readingItem)
            println(user.readingItems.size())
        }
        println(user.subscriptions.size()+" "+topic.subscriptions.size()+" "+user.readingItems.size())
        user.addToSubscriptions(subscription)
        topic.addToSubscriptions(subscription)
        println(user.subscriptions.size()+" "+topic.subscriptions.size()+" "+user.readingItems.size())
    }
}
