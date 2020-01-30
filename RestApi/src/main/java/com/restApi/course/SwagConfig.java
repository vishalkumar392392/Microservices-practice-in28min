package com.restApi.course;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwagConfig {

	/*
	 * public static final Contact DEFAULT_CONTACT = new Contact(
	 * "vishal","http://www.iN28MINUTES.COM","vishalpalla27@gmail.com");
	 * 
	 * public static final ApiInfo Default_API_INFO= new
	 * ApiInfo("Awesome API Title", "Awesome API Documentation","1.0",
	 * "urn:tos",DEFAULT_CONTACT, "Apache 2.0",
	 * "http://www.apache.org/licenses/LICENSE-2.0" );
	 */
	
	@Bean
	public Docket getDocket() {
		
		return new Docket(DocumentationType.SWAGGER_2);
	}

}
