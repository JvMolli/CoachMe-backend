package coachMe.com.example.CoachMe.model.User
import javax.persistence.*

@Entity
@Table
data class UserImages(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id:Long = 0,
                      @ManyToOne(optional = false, cascade = [CascadeType.REMOVE]) @JoinColumn(referencedColumnName="id") val userId: User,
                      @Column(nullable = false) val path: String = ""){}