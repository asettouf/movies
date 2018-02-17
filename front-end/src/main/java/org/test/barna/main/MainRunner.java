package org.test.barna.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication(scanBasePackages={"org.test.barna", "org.test.Connectors"})
@ImportResource("classpath:spring.xml")
public class MainRunner 
{


  public static void main(String[] args) throws Exception {
      SpringApplication.run(MainRunner.class, args);
  }
}
