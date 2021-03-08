package coachMe.com.CoachMe.dao

import coachMe.com.CoachMe.model.User.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRespository: JpaRepository<User, Long>