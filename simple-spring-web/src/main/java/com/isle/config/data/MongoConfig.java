package com.isle.config.data;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

/**
 * 配置mongodb
 * Created by 61066 on 2017/12/28.
 */
@Configuration
@PropertySource("classpath:database.properties")
@EnableMongoRepositories(basePackages = "com.isle.**.dao.mongo")
public class MongoConfig extends AbstractMongoConfiguration {

    @Autowired
    private Environment environment;

    @Override
    protected String getDatabaseName() {
        return environment.getProperty("mongo.database");
    }

    @Override
    public Mongo mongo() throws Exception {
        MongoCredential credential =
                MongoCredential.createMongoCRCredential(
                        environment.getProperty("mongo.username"),
                        environment.getProperty("mongo.database"),
                        environment.getProperty("mongo.password").toCharArray()
                );
        return new MongoClient(
                new ServerAddress(
                        environment.getProperty("mongo.url"),
                        Integer.parseInt(environment.getProperty("mongo.port"))),
                Arrays.asList(credential)
        );
    }

}
