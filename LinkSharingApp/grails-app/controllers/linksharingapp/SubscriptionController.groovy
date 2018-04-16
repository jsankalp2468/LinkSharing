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
        Subscription subscription = Subscription.findByIdAndSeriousness(id,Seriousness.isSeriousness(seriousness))

        if (subscription){
            if(subscription.validate()){
                subscription.save(flush:true)
                render("Subscription saved successfully")
            }
            else {
                render("Subscription not saved ${subscription.errors.allErrors}")
            }

        }else {
            render("Subscription not found")
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
        flash.message = "subscribed successfully!!"
        redirect(controller : 'logIn',action: 'index')
    }
}
