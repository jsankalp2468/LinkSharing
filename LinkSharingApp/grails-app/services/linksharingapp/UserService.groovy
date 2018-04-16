package linksharingapp

import grails.gorm.transactions.Transactional

@Transactional
class UserService {
    def findUserFromUserId(Long userId){
        User user = User.findById(userId)
    }
}
