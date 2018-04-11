package linksharingapp

import grails.gorm.transactions.Transactional

@Transactional
class ReadingItemService {

   def findReadingItemsForAUser(User user,def max,def offset){
       ReadingItem.createCriteria().list(max: max,offset: offset){
           eq("user",user)
       }
   }
}
