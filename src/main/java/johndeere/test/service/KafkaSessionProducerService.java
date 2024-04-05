package johndeere.test.service;

import johndeere.test.models.SessionDTO;

public interface KafkaSessionProducerService  {
    void send(String topicName, String key, SessionDTO value);
}
