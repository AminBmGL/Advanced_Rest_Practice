package tn.insat.restpractice.restwebservicepractice.config;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket api() {
		HashSet<String> consumesAndProduces = new HashSet<String>(Arrays.asList("application/json", "application/xml"));
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(metadata())
				.consumes(consumesAndProduces)
				.produces(consumesAndProduces)
				.pathMapping("/");
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("Swagger Api For Social Media App")
				.description("User and Posts API")
				.version("1.0")
				.contact(new Contact("Amin", "http://www.insat.tn",
						"amin@gmail.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}
}
