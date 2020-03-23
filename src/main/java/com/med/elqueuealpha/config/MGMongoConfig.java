package com.med.elqueuealpha.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.med.elqueuealpha.repository.mg",
        mongoTemplateRef = "mgMongoTemplate")
public class MGMongoConfig { }
