package linksharingapp

class LinkResource extends Resource{

    String url

    LinkResource(String url) {
        this.url = url
    }
    static constraints = {
        url(url: true)
    }
}
