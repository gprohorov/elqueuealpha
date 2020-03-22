package com.med.elqueuealpha.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.med.elqueuealpha.repository.kl",
        mongoTemplateRef = "klMongoTemplate")
public class KLMongoConfig {

}
