package com.nokia.test.nokiastackservice.Config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String SWAGGER_API_INFO_TITLE = "nokia-stack-service";
	private static final String SWAGGER_API_INFO_DESCRIPTION = "API documentation of the `Nokia Stack Service` developed as assignment for interview with Nokia";
	private static final String SWAGGER_API_INFO_VERSION = "1.0.0";
	private static final String SWAGGER_API_INFO_TOS = "";
	private static final String SWAGGER_API_INFO_NAME = "Syed Ruhan";
	private static final String SWAGGER_API_INFO_URL = "https://github.com/ruhan008/nokia-stack-service";
	private static final String SWAGGER_API_INFO_EMAIL = "syed.ruhan@gmail.com";
	private static final String SWAGGER_API_INFO_LICENSE = "Apache 2.0";
	private static final String SWAGGER_API_INFO_LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0";
	private static final Set<String> DEFAULT_PRODUCES = new HashSet<String>(Arrays.asList("application/json"));
	private static final Set<String> DEFAULT_CONSUMES = new HashSet<String>(Arrays.asList("application/json"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.regex("/nokia-stack-service.*"))
				.apis(RequestHandlerSelectors.any()).build().apiInfo(apiDetails()).produces(DEFAULT_PRODUCES)
				.consumes(DEFAULT_CONSUMES);
	}

	private ApiInfo apiDetails() {

		Contact contact = getContact();

		ApiInfo apiInfo = new ApiInfoBuilder().title(SWAGGER_API_INFO_TITLE).description(SWAGGER_API_INFO_DESCRIPTION)
				.version(SWAGGER_API_INFO_VERSION).termsOfServiceUrl(SWAGGER_API_INFO_TOS).contact(contact)
				.license(SWAGGER_API_INFO_LICENSE).licenseUrl(SWAGGER_API_INFO_LICENSE_URL).build();

		return apiInfo;

	}

	private Contact getContact() {

		Contact contact = new Contact(SWAGGER_API_INFO_NAME, SWAGGER_API_INFO_URL, SWAGGER_API_INFO_EMAIL);
		return contact;
	}

}
