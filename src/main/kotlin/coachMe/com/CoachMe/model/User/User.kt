package coachMe.com.CoachMe.model.User

import coachMe.com.CoachMe.Utilities.UserTypes
import java.sql.Date
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table
data class User(@Column(nullable = false) val name:String = "",
                @Column(nullable = false) val surname:String = "",
                val description: String? = null,
                @Column(unique = true)val personalid: String? = null,
                @Column(nullable = false) val birthDate: Date = Date(0),
                @Column(nullable = false) val type: Enum<UserTypes> = UserTypes.CLIENT,
                @Column(nullable = false) val weight: Double? = null,
                @Column(nullable = false) val height: Int? = null,
                @Column(nullable = false)val profilePictures: String = "/rutaquesea",
                @Column(nullable = false, unique = true) val email: String = "",
                @Column(nullable = false) val password: String = "") {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long = 0

}