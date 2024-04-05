package johndeere.test.service.kafka;

import johndeere.test.models.EventSessionDTO;

public interface KafkaEventProducerService {
    void send(String topicName, String key, EventSessionDTO value);
}
