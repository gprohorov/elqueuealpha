package com.med.elqueuealpha.config;

import com.mongodb.MongoClient;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MultipleMongoProperties.class)
public class MultipleMongoConfig {

    private final MultipleMongoProperties mongoProperties;

    public MultipleMongoConfig(MultipleMongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    @Primary
    @Bean(name = "primaryMongoTemplate")
    public MongoTemplate primaryMongoTemplate() throws Exception {
        return new MongoTemplate(primaryFactory(this.mongoProperties.getPrimary()));
    }

    @Bean(name = "secondaryMongoTemplate")
    public MongoTemplate secondaryMongoTemplate() throws Exception {
        return new MongoTemplate(secondaryFactory(this.mongoProperties.getSecondary()));
    }

    @Bean(name = "tertiaryMongoTemplate")
    public MongoTemplate tertiaryMongoTemplate() throws Exception {
        return new MongoTemplate(tertiaryFactory(this.mongoProperties.getTertiary()));
    }

    @Bean(name = "sdcvMongoTemplate")
    public MongoTemplate sdcvMongoTemplate() throws Exception {
        return new MongoTemplate(sdcvFactory(this.mongoProperties.getSdcv()));
    }

    @Bean
    @Primary
    public MongoDbFactory primaryFactory(final MongoProperties mongo) throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }

    @Bean
    public MongoDbFactory secondaryFactory(final MongoProperties mongo) throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }

    @Bean
    public MongoDbFactory tertiaryFactory(final MongoProperties mongo) throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }

    @Bean
    public MongoDbFactory sdcvFactory(final MongoProperties mongo) throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()), mongo.getDatabase());
    }
}
