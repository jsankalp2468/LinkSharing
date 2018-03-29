package linksharingapp

class LinkResource extends Resource{

    String url

    LinkResource(Map namedArgs, String url) {
        super(namedArgs)
        this.url = url
    }
    static constraints = {
        url(url: true)
    }
}
