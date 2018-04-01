package linksharingapp

class ReadingItemController {

    def index() { }

    def changeIsRead(Long id,boolean isRead){
        if(ReadingItem.executeUpdate('update ReadingItem set isRead=:isRead where id=:id1',[isRead:isRead,id1:id])==0){
            render("error")
        }
        else {
            render("success")
        }
    }
}
