package johndeere.test.service;

import johndeere.test.models.TaskStatus;

public interface KafkaProducerService {
    void send(String topicName, String key, TaskStatus value);
}
