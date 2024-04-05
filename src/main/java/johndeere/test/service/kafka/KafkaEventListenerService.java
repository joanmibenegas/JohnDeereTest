package johndeere.test.service.kafka;

import johndeere.test.models.EventSessionDTO;
import org.springframework.kafka.annotation.KafkaListener;

public interface KafkaEventListenerService {
    @KafkaListener(topics = {"event-topic"}, groupId = "task-group")
    void consume(EventSessionDTO eventSessionDTO);
}
