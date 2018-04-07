package linksharingapp

class Dummy {
    String name
    String email
    byte[] avatar
    static constraints = {
        avatar(sqlType: 'longBlob')
    }
}
