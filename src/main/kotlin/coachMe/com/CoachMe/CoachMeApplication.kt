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
class CoachMeFileServerApplication: CommandLineRunner{
	override  fun run(vararg args: String?){}
}

fun main(args: Array<String>) {
	runApplication<CoachMeFileServerApplication>(*args)
}
