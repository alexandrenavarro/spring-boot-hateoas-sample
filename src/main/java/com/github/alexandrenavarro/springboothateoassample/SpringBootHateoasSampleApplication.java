package com.github.alexandrenavarro.springboothateoassample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL_FORMS)
public class SpringBootHateoasSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHateoasSampleApplication.class, args);
	}

}
