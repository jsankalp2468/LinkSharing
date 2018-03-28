package User

class User {

    String firstName
    String lastName
    String email
    String userName
    String password
    byte photo
    boolean admin
    boolean active
    Date dateCreated
    Date lastUpdated

    static constraints = {
        email(email: true,nullable: false,blank: false,unique: true)//Nullable : Allows a property to be set to null - defaults to false.
        password(nullable: false,blank: false,min: 5)
        firstName(nullable: false,blank: false)
        lastName(nullable: false,blank: false)
        photo(nullable: true)
        admin(nullable: true)
        active(nullable: true)
    }
}
