package com.unibro.ngsi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import java.io.IOException;
import java.util.Properties;

/**
 * AppConfig.
 *
 * @author ThoND
 */
@Configuration
@EnableTransactionManagement

public class AppConfig {
//    @Bean
//    public VelocityEngine getVelocityEngine() throws VelocityException, IOException {
//        Properties props = new Properties();
//        props.put("resource.loader", "class");
//        props.put("class.resource.loader.class",
//                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
//        props.put("input.encoding", "UTF-8");
//        VelocityEngineFactory velocityEngineFactory = new VelocityEngineFactory();
//        velocityEngineFactory.setVelocityProperties(props);
//        return velocityEngineFactory.createVelocityEngine();
//    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
