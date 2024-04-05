package johndeere.test.service.kafka;

import johndeere.test.models.SessionDTO;

public interface KafkaSessionProducerService  {
    void send(String topicName, String key, SessionDTO value);
}
