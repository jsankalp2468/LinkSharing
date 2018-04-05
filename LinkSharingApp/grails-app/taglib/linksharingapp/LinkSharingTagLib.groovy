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
                value = "Mark as UnRead"
            }else {
                value = "Mark as Read"
            }
        }
        else {
            value = null
        }

        out << body() << value
    }
}
