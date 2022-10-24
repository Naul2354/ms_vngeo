package com.unibro.ngsi.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Config.
 *
 * @author THOND
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.unibro.ngsi")).build().apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("Vietnam Province Rest API", "Rest API for", "1.0", "Terms of service",
                new Contact("Thond", "", ""), "", "");
        return apiInfo;
    }

//    @Bean
//    public Docket productApi() {
//        ParameterBuilder aParameterBuilder = new ParameterBuilder();
////        aParameterBuilder.name("Authorization").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
////        List<Parameter> aParameters = new ArrayList<Parameter>();
////        aParameters.add(aParameterBuilder.build());
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select().apis(RequestHandlerSelectors.basePackage("com.unibro.vov_transport"))
//                .paths(regex("/api.*"))
//                .build().apiInfo(ApiInfo.DEFAULT).pathMapping("");
//    }
//    private ApiInfo metaData() {
//        ApiInfo apiInfo = new ApiInfo(
//                "Spring Boot REST API",
//                "Spring Boot REST API for Ftel Service",
//                "1.0",
//                "Terms of service",
//                new Contact("Tho Nguyen Duc", "http://", "thodt6@gmail.com"),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licenses/LICENSE-2.0");
//        return apiInfo;
//    }
}
