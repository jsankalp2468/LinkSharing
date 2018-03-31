package linksharingapp

import enumeration.Seriousness

class SubscriptionController {

    def index() { }

    def save(Long topicId) {
        Topic topic = Topic.get(topicId)
        Subscription subscription = new Subscription(topic: topic,user: session.user,seriousness: Seriousness.VERY_SERIOUS)
        if(subscription.validate()){
            subscription.save()
            render("Subscription saved successfully")
        }else {
            render("Subscription not saved successfully ${subscription.errors.allErrors}")
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

    def delete(Long id) {
        Subscription subscription = Subscription.load(id)
        try{
            subscription.delete(flush:true)
            render("Subscription deleted successfully")
        }catch (RuntimeException ex){
            render("Subscription with this id not found")
        }
    }
}
