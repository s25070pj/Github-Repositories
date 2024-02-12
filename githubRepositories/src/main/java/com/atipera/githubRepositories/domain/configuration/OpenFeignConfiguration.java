package com.atipera.githubRepositories.domain.configuration;


import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignConfiguration {
    @Bean
    public Decoder feignDecoder(){
        return new JacksonDecoder();
    }
}
