package linksharingapp

class LinkSharingTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "ls"

    def checkRead = { attrs,body ->
        def value;
        Boolean aBoolean = new Boolean(attrs.isRead)
        if(session.user){
            if(aBoolean){
                value = "Mark as Read"
            }else {
                value = "Mark as Unread"
            }
        }
        else {
            value = null
        }

        out << body() << value
    }
}
