package rewards.customers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
 import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())                          
                .apis(RequestHandlerSelectors.basePackage("rewards.customers"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Customer Rewards  API", //title
                "Calculate the reward point earned for each customer per month", //description
                "Version 1.0", //version
                "Terms of service", //terms of service URL
                new Contact("Prateek Verma", "www.prateektest.com", "prateek.4890@gmail.com"),
                "License of API", "API license URL", java.util.Collections.emptyList()); // contact info
    }
}
