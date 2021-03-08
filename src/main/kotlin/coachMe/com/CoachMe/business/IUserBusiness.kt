package coachMe.com.CoachMe.business

import coachMe.com.CoachMe.model.User.User

interface IUserBusiness {

    fun list(): List<User>
    fun load(userId: Long): User
    fun save(user: User): User
    fun remove(userId: Long)
}