package linksharingapp

class DummyController {

    def index() { }

    def save(){
        def dummy = new Dummy(params)
        println(request.getFile("avatar").inputStream.text)
        if(dummy.validate()){
            dummy.save(flush:true)
            def avatar = request.getFile('avatar')
            avatar.transferTo(new java.io.File("/home/sankalp/Desktop/sankalp.jpg"))
            render("success")
        }else {

            render("${dummy.errors.allErrors}")
        }

    }

    def show(){
        def file = new File("/home/sankalp/Desktop/${params.name}.jpg")
        def img = file.bytes
        response.contentType = '*' // or the appropriate image content type
        response.outputStream << img
        response.outputStream.flush()
    }
}
