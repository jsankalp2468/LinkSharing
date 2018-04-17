package linksharingapp

import enumeration.Seriousness

class SubscriptionController {

    def userService

    def index() { }

    def save() {
        Topic topic = Topic.get(params.id.toLong())
        User user = userService.findUserFromUserId(session.userId)
        Subscription subscription = new Subscription(topic: topic,user: user,seriousness: Seriousness.VERY_SERIOUS)
        if(subscription.validate()){
            subscription.save()
            redirect(controller : 'logIn',action: 'index')
        }else {
            flash.error = "Subscription not saved."
//            render("${subscription.errors.allErrors}")
            redirect(controller : 'logIn',action: 'index')
        }

    }

    def update(Long id,String seriousness) {
        Subscription subscription = Subscription.findById(id)
        if (subscription){
            subscription.seriousness = Seriousness.isSeriousness(seriousness)
            if(subscription.validate()){
                subscription.save(flush:true)
                flash.message = "Subscription saved successfully"
//                render("Subscription saved successfully")
                redirect(controller: 'user',action: 'index')
            }
            else {
                flash.error = "Subscription not saved ${subscription.errors.allErrors}"
//                render("Subscription not saved ${subscription.errors.allErrors}")
                redirect(controller: 'user',action: 'index')
            }

        }else {
            flash.error = "Subscription not found"
//            render("Subscription not found")
            redirect(controller: 'user',action: 'index')
        }
    }

    def delete() {
        Topic topic = Topic.findById(params.id.toLong())
        User user = userService.findUserFromUserId(session.userId)
        Subscription subscription = Subscription.findByUserAndTopic(user,topic)
        if(user.subscriptions.contains(subscription) && user!=topic.createdBy){
            List<Resource> resource = Resource.findAllByTopic(topic)
            println(resource)
            resource.each {
                ReadingItem readingItem = ReadingItem.findByUserAndResource(user,it)
                println(readingItem)
                println(user.readingItems.size())
                if(user.readingItems.contains(readingItem)){
                    user.removeFromReadingItems(readingItem)
                    readingItem.delete(flush: true)
                    println("removed")
                }
                println(user.readingItems.size())
            }
            user.removeFromSubscriptions(subscription)
            topic.removeFromSubscriptions(subscription)
            try{
                subscription.delete(flush:true)
                flash.message = "subscription deleted successfully"
                redirect(controller : 'logIn',action: 'index')
            }catch (RuntimeException ex){
                flash.error = "error while deleting subscription ${subscription.errors.allErrors} ${subscription}"
                render("error while deleting subscription ${subscription.errors.allErrors} ${subscription}")
                redirect(controller : 'logIn',action: 'index')
            }
        }
    }

    def subscribe(){
        Topic topic = Topic.findById(params.id.toLong())
        User user = userService.findUserFromUserId(session.userId)
        Subscription subscription = new Subscription(topic: topic,user: user,seriousness: Seriousness.VERY_SERIOUS)
        List<Resource> resource = Resource.findAllByTopic(topic)
        println(resource)
        resource.each {
            ReadingItem readingItem = new ReadingItem(resource: it,user: user,isRead: false)
            user.addToReadingItems(rea)
            println(user.readingItems.size())
        }
        println(user.subscriptions.size()+" "+topic.subscriptions.size())
        user.addToSubscriptions(subscription)
        topic.addToSubscriptions(subscription)
        println(user.subscriptions.size()+" "+topic.subscriptions.size())

    }
}
