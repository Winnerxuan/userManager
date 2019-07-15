package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
@Configuration
@EnableSwagger2
public class SwaggerConfigure {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.controller"))
				.paths(PathSelectors.any()).build();
	}
 
	private ApiInfo apiInfo() { 
		return new ApiInfoBuilder().title("userManager的API")
				.description("综合管理 Swagger API 服务")
				.termsOfServiceUrl("http://swagger.io/")
				.contact(new Contact("Winner", "127.0.0.1", "823713793@qq.com"))
				.version("1.0")
				.build();
 
	}
 
}
