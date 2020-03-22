package com.med.elqueuealpha.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {

    private final MongoProperties cv = new MongoProperties();
    private final MongoProperties kl = new MongoProperties();
    private final MongoProperties mg = new MongoProperties();

    public MongoProperties getCv() {
        return cv;
    }

    public MongoProperties getKl() {
        return kl;
    }

    public MongoProperties getMg() {
        return mg;
    }
}
