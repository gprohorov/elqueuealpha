package com.med.elqueuealpha.config;

import com.mongodb.MongoClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
@EnableConfigurationProperties(MultipleMongoProperties.class)
public class MultipleMongoConfig {

    private final MultipleMongoProperties mongoProperties;

    @Autowired
    public MultipleMongoConfig(MultipleMongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    @Primary
    @Bean(name = "cvMongoTemplate")
    public MongoTemplate cvMongoTemplate() throws Exception {
        return new MongoTemplate(cvFactory(this.mongoProperties.getCv()));
    }

    @Bean(name = "klMongoTemplate")
    public MongoTemplate klMongoTemplate() throws Exception {
        return new MongoTemplate(klFactory(this.mongoProperties.getKl()));
    }

    @Bean(name = "mgMongoTemplate")
    public MongoTemplate mdMongoTemplate() throws Exception {
        return new MongoTemplate(mgFactory(this.mongoProperties.getMg()));
    }

    @Bean
    @Primary
    public MongoDbFactory cvFactory(final MongoProperties mongo) throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }

    @Bean
    public MongoDbFactory klFactory(final MongoProperties mongo) throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }

    @Bean
    public MongoDbFactory mgFactory(final MongoProperties mongo) throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }
}
