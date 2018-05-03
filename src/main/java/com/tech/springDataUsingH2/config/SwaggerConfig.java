package com.tech.springDataUsingH2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	
	@Bean
	public Docket productApi(){
		return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.tech.springDataUsingH2.controllers"))
                .paths(PathSelectors.any())
                .build()
              .apiInfo(metaData());
    }
	
	private ApiInfo metaData() {
		
        ApiInfo apiInfo = new ApiInfo( "Swagger Employee Documentation",
                "Project is developed using spring(boot) data with embedded H2 database. This is employee api documentation. The document list out all APIs that supports employee operations like saving, fecthing employee by id and employee listing.",
                "1.0.0",
                "http://swagger.io/terms/", "Jasleenkhurana48@gmail.com", "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
	
}
