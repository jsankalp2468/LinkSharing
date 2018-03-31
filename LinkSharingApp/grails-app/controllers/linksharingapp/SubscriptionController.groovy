package linksharingapp

class SubscriptionController {

    def index() { }

    def save() { }

    def update() { }

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
