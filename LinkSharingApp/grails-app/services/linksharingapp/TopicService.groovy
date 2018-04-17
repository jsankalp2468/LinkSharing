package linksharingapp

import grails.gorm.transactions.Transactional

@Transactional
class TopicService {

    def changeIsReadToFalse(User user, Long resourceId) {
        Resource resource = Resource.findById(resourceId)
        ReadingItem readingItem = ReadingItem.findByUserAndResource(user, resource)
//        println("Before ${readingItem.isRead}")
        readingItem.isRead = false
        readingItem.save(flush: true)
        readingItem.errors.allErrors
//        println("After ${readingItem.isRead}")

    }

    def changeIsReadToTrue(User user, Long resourceId) {
        Resource resource = Resource.findById(resourceId)
        ReadingItem readingItem = ReadingItem.findByUserAndResource(user, resource)
//        println("Before ${readingItem.isRead}")
        readingItem.isRead = true
        readingItem.errors.allErrors
//        println("After ${readingItem.isRead}")

    }
}
