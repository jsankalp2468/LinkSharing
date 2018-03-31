package linksharingapp

import co.ResourceSearchCO

abstract class Resource {

    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated
    //createdBy description topic already created
    static belongsTo = [createdBy:User,topic:Topic]
    static hasMany = [ratings:ResourceRating, readingItems:ReadingItem]
    static constraints = {
        description(type: "text")
    }
    static namedQueries = {
        search{ ResourceSearchCO co ->
            eq('topic.id',co.topicId)
            topic{
                eq('visibility',co.visibility)
            }
        }
    }
}
