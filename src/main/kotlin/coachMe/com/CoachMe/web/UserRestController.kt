package coachMe.com.CoachMe.web

import coachMe.com.CoachMe.Utilities.Constants
import coachMe.com.CoachMe.business.IUserBusiness
import coachMe.com.CoachMe.exception.BusinessException
import coachMe.com.CoachMe.exception.NotFoundException
import coachMe.com.CoachMe.model.User.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping(Constants.URL_BASE_USERS)
class UserRestController {
    @Autowired
    val userBusiness: IUserBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<User>>{
        return try {
            ResponseEntity(userBusiness!!.list(), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/id")
    fun load(@PathVariable("id") userId: Long): ResponseEntity<Any>{
        return try {
            ResponseEntity(userBusiness!!.load(userId), HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody user: User): ResponseEntity<Any>{
        return try {
            userBusiness!!.save(user)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", Constants.URL_BASE_USERS + "/" + user.id)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody user: User): ResponseEntity<Any>{
        return try {
            userBusiness!!.save(user)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") userId: Long): ResponseEntity<Any>{
        return try {
            userBusiness!!.remove(userId)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

}