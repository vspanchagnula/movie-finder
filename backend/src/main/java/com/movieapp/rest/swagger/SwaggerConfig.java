package com.movieapp.rest.swagger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
	@Bean
    public Docket api(ServletContext servletContext) {
      return new Docket(DocumentationType.SWAGGER_2).select()
    		  .apis(RequestHandlerSelectors
    	                .basePackage("com.movieapp"))
    		  			.paths(PathSelectors.regex("(?!/error).+"))
    		  			.build()
    		  	.securitySchemes(Arrays.asList(apiKey()))
    		  	.securityContexts(Collections.singletonList(securityContext()));
    }

    private SecurityContext securityContext() {
      return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/.*")).build();
    }

  private List<SecurityReference> defaultAuth() {
    final AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    final AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
    return Collections.singletonList(new SecurityReference("Bearer", authorizationScopes));
  }

  private ApiKey apiKey() {
    return new ApiKey("Bearer", "Authorization", "header");
  } 
}

