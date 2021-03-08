package coachMe.com.CoachMe.business

import coachMe.com.CoachMe.dao.UserRespository
import coachMe.com.CoachMe.exception.BusinessException
import coachMe.com.CoachMe.exception.NotFoundException
import coachMe.com.CoachMe.model.User.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*
import kotlin.jvm.Throws

@Service
class UserBusiness: IUserBusiness {

    @Autowired
    val userRespository: UserRespository? = null

    @Throws(BusinessException::class)
    override fun list(): List<User> {

        try {
            return userRespository!!.findAll()
        }catch (e: Exception){
            throw BusinessException(e.message)
        }

    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(userId: Long): User {
        val op: Optional<User>
        try {
            op = userRespository!!.findById(userId)
        }catch (e: Exception){
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("This user is not exist")
        }
        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(user: User): User {
        try {
            return userRespository!!.save(user)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class)
    override fun remove(userId: Long) {
        val op: Optional<User>
        try {
            op = userRespository!!.findById(userId)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
        if(!op.isPresent){
            throw NotFoundException("User is not exist")
        }else{
            try {
                userRespository!!.deleteById(userId)
            }catch (e:Exception){
                throw BusinessException(e.message)
            }
        }
    }


}