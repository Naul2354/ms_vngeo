package com.unibro.ngsi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration

public class ThreadConfig {

    /**
     * thread send mail.
     *
     * @return
     */
    @Bean
    @Scope(value = "singleton")
    public ExecutorService threadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        return executorService;
    }

}
