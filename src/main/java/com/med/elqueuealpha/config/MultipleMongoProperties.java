package com.med.elqueuealpha.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {

    private MongoProperties primary = new MongoProperties();
    private MongoProperties secondary = new MongoProperties();
    private MongoProperties tertiary = new MongoProperties();
    private MongoProperties sdcv = new MongoProperties();
}
