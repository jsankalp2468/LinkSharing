package linksharingapp

import co.ResourceSearchCO
import vo.RatingInfoVO

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

    static transients = ['ratingInfo']
    static namedQueries = {
        search{ ResourceSearchCO co ->
            eq('topic.id',co.topicId)
            topic{
                eq('visibility',co.visibility)
            }
        }
    }

    RatingInfoVO method(){
        RatingInfoVO vo = new RatingInfoVO()

        vo.totalVotes = ResourceRating.createCriteria().count{
            eq('resource',this)
        }
        List averageScore = ResourceRating.createCriteria().list{
            projections{
                avg('score')
            }
            eq('resource',this)
        }
        vo.averageScore = averageScore[0]


        List totalScore = ResourceRating.createCriteria().list {
            projections{
                sum('score')
            }
            eq('resource',this)
        }
        vo.totalScore = totalScore[0]


        return vo
    }

    Long totalVotes(){
        Long vote = ResourceRating.createCriteria().count(){
            eq('resource',this)
        }
        return vote
    }



}
