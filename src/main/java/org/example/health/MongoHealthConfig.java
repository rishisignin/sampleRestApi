package org.example.health;

import org.bson.Document;
import org.springframework.boot.health.contributor.AbstractHealthIndicator;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoHealthConfig {

    private static final Document PING_COMMAND = new Document("ping", 1);

    @Bean(name = "mongoHealthIndicator")
    public HealthIndicator mongoHealthIndicator(MongoTemplate mongoTemplate) {
        return new AbstractHealthIndicator("MongoDB health check failed") {
            @Override
            protected void doHealthCheck(Health.Builder builder) {
                Document result = mongoTemplate.getDb().runCommand(PING_COMMAND);
                builder.up()
                        .withDetail("database", mongoTemplate.getDb().getName())
                        .withDetail("ok", result.get("ok"));
            }
        };
    }
}
