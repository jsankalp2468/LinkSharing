package linksharingapp

import co.ResourceSearchCO
import vo.RatingInfoVO
import vo.TopPostVO

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

    static List<TopPostVO> getTopPosts(){
        List<TopPostVO> topPostVOList = ResourceRating.createCriteria().list {
            projections{
                createAlias('resource','res')
                groupProperty('res.id')
                property('res.createdBy')
                createAlias('res.topic','t')
                property('t.name')
                count('res.id','counts')
            }
            order('counts','desc')
            maxResults(5)
        }
        return topPostVOList
    }

    Long totalVotes(){
        Long vote = ResourceRating.createCriteria().count(){
            eq('resource',this)
        }
        return vote
    }



}
