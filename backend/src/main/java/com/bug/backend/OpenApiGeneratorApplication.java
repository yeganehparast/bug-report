package com.bug.backend;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bug.backend", "com.bug.backend.api",
    "com.bug.backend.configuration"})
public class OpenApiGeneratorApplication {

  public static void main(String[] args) {
    SpringApplication.run(OpenApiGeneratorApplication.class, args);
  }

  @Bean
  public Module jsonNullableModule() {
    return new JsonNullableModule();
  }

}