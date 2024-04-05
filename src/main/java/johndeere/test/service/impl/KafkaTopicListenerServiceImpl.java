package johndeere.test.service.impl;

import johndeere.test.models.TaskStatus;
import johndeere.test.service.KafkaTopicListenerService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log
public class KafkaTopicListenerServiceImpl implements KafkaTopicListenerService {
    private final Logger logger = LoggerFactory.getLogger(KafkaTopicListenerServiceImpl.class);

    @KafkaListener(topics = {"event-topic"}, groupId = "task-group")
    public void consume(TaskStatus taskStatus) {
        logger.info(String.format("Task status is updated : " + taskStatus));
    }
}
