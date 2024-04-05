package johndeere.test.service;

import johndeere.test.models.base.BaseDTO;

public interface KafkaProducerService {
    void send(String topicName, String key, BaseDTO value);
}
