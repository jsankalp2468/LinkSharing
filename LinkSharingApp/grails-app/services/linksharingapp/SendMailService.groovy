package linksharingapp

import dto.EmailDTO
import grails.gorm.transactions.Transactional

@Transactional
class SendMailService {

    static transactional = false
    def mailService

    def sendMail1(EmailDTO emailDTO) {
        mailService.sendMail {
            to emailDTO.to
            subject emailDTO.subject
            body emailDTO.content
        }
    }


    def sendInvitation(EmailDTO emailDTO)
    {
        println("in email service")
        mailService.sendMail {
            to emailDTO.to
            subject emailDTO.subject
            html view: '/layouts/_invite', model: [link: "${emailDTO.linkId}",email:"${emailDTO.to}"]
        }
    }

    def sendUnreadResourcesEmail() {
        mailService.sendMail {
            to emailDTO.to
            subject emailDTO.subject
            html view: "/email/UnreadResources", model: [list1: "${emailDTO.itemList}", list2: "${emailDTO.createrList}"]
        }
    }

}
