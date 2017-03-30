package org.springscala.entity

import scala.beans.BeanProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import java.lang.Long
import javax.persistence.OneToMany
import java.util.Set
import java.io.Serializable
import javax.persistence.GenerationType
import javax.persistence.Column

@Entity
class Users extends Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  @Column(name = "username")
  var username: String = _

  @BeanProperty
  @Column(name = "password")
  var password: String = _

  @BeanProperty
  @Column(name = "enabled")
  var enabled: Boolean = _

}