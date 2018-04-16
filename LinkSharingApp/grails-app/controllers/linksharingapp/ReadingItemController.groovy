package linksharingapp

class ReadingItemController {

    def userService

    def index() { }

    def changeIsRead(Long resourceId){
        User user = userService.findUserFromUserId(session.userId)
        ReadingItem readingItem = ReadingItem.findByUserAndResource(user,Resource.findById(resourceId))
        if((ReadingItem.executeUpdate('update ReadingItem set isRead=:isRead where id=:id1',[isRead:readingItem.isRead,id1:resourceId]))==0){
            render("error")
        }
        else {
            render("success")
        }
    }
}
