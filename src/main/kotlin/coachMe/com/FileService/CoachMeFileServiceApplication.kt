package coachMe.com.FileService

import coachMe.com.CoachMe.dao.UserRespository
import coachMe.com.CoachMe.model.User.User
import coachMe.com.FileService.business.FileServiceSave
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.File
import java.sql.Timestamp
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@SpringBootApplication
class CoachMeApplication: CommandLineRunner{

	@Autowired
	val userRespository: UserRespository? = null

	override  fun run(vararg args: String?){
		val pepe =  Timestamp(System.currentTimeMillis());
		val newImagesave = FileServiceSave("mokeduserid12345",pepe);

		println("TEST" + newImagesave.saveProfilePicture(File("waa")))
	}
}

fun main(args: Array<String>) {
	runApplication<CoachMeApplication>(*args)
}
