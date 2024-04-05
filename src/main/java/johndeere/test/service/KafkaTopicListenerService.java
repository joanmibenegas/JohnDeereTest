package johndeere.test.service;

import johndeere.test.models.base.BaseDTO;
import org.springframework.kafka.annotation.KafkaListener;

public interface KafkaTopicListenerService {
    @KafkaListener(topics = {"session-topic"}, groupId = "task-group")
    void consume(BaseDTO baseDTO);
}
