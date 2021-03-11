package coachMe.com.CoachMe

import coachMe.com.CoachMe.dao.UserRespository
import coachMe.com.CoachMe.model.User.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@SpringBootApplication
class CoachMeApplication: CommandLineRunner{

	@Autowired
	val userRespository: UserRespository? = null

	override  fun run(vararg args: String?){
		val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
		val user1 = User(name = "Fortachio", surname = "Mollineo", password = "okokokok", description = "Soy un pobre diablo",
			profilePictures = "/nudesdeJaime", email = "jaime@fuerte.es", height = Integer(180),weight = 80.9
		)

		userRespository!!.save(user1)
	}
}

fun main(args: Array<String>) {
	runApplication<CoachMeApplication>(*args)
}
