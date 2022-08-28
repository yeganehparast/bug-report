package com.bug.backend.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

  @Bean
  OpenAPI apiInfo() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Bug Tracker")
                .description(
                    "This API provides endpoints for adding a bug, list the bugs, update a bug's information such as assignee and description and finally find a bug")
                .termsOfService("https://www.opensource.org/licenses/MIT")
                .contact(
                    new Contact()
                        .email("mehdi.yeganehparast@gmail.com")
                )
                .license(
                    new License()
                        .name("MIT Licence")
                        .url("https://opensource.org/licenses/MIT")
                )
                .version("1.0.0")
        )
        ;
  }
}