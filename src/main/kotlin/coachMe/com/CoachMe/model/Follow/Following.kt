package coachMe.com.CoachMe.model.Follow

import coachMe.com.CoachMe.model.User.User
import java.io.Serializable
import javax.persistence.*

@Entity
@Table
data class Following (@Id @GeneratedValue(strategy = GenerationType.AUTO) var id:Long = 0,
                      @ManyToOne(optional = false, cascade = [CascadeType.REMOVE]) @JoinColumn(referencedColumnName = "id") val follower: User,
                      @ManyToOne(optional = false, cascade = [CascadeType.REMOVE]) @JoinColumn(referencedColumnName = "id") val following: User,
                     ) : Serializable
{

}
