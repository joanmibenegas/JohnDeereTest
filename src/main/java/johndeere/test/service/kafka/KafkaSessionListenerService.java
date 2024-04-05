package johndeere.test.service.kafka;

import johndeere.test.models.SessionDTO;
import org.springframework.kafka.annotation.KafkaListener;

public interface KafkaSessionListenerService {
    @KafkaListener(topics = {"session-topic"}, groupId = "task-group")
    void consume(SessionDTO sessionDTO);
}
