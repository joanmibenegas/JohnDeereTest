package johndeere.test;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic eventTopic() {
        return TopicBuilder.name("event-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic sessionTopic() {
        return TopicBuilder.name("session-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
