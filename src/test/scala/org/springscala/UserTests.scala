package org.springscala

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner
import org.junit.Test
import java.util.List
import org.springscala.entity.Users
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.http.HttpHeaders
import org.apache.tomcat.util.codec.binary.Base64
import java.nio.charset.Charset
import org.springframework.http.HttpEntity
import org.springframework.http.MediaType
import org.springframework.http.MediaTypeEditor
import java.util.Arrays

@RunWith(classOf[SpringRunner])
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserTests {

  @Autowired var template: TestRestTemplate = _

  @Test
  def testPostCreateUser() = {
    val headers = new HttpHeaders
    headers.add("Authorization", "Basic " + new String(Base64.encodeBase64(("root" + ":" + "root").getBytes())))
    headers.setContentType(MediaType.APPLICATION_JSON)
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON))
    val user = new Users
    user.setId(101)
    user.setUsername("Test")
    user.setPassword("Test")
    user.setEnabled(true)
    val entity = new HttpEntity(user, headers)
    val result = template.postForObject("/api/users", entity, classOf[String])
    println(result)
  }

}