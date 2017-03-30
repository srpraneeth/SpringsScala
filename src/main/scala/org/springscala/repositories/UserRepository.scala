package org.springscala.repositories

import org.springframework.stereotype.Repository
import org.springscala.entity.Users
import org.springframework.data.repository.CrudRepository
import java.lang.Long

@Repository
trait UserRepository extends CrudRepository[Users, Long] {

  def findUserByUsername(username: String): Users

}

