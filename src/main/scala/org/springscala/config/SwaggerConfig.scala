package org.springscala.config

import springfox.documentation.swagger2.annotations.EnableSwagger2
import org.springframework.context.annotation.Configuration
import springfox.documentation.spring.web.plugins.Docket
import org.springframework.context.annotation.Bean
import springfox.documentation.spi.DocumentationType
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.builders.PathSelectors

@Configuration
@EnableSwagger2
class SwaggerConfig {

  @Bean
  def api(): Docket = {
    new Docket(DocumentationType.SWAGGER_2)
      .select
      .apis(RequestHandlerSelectors.any)
      .paths(PathSelectors.any)
      .build
  }

}