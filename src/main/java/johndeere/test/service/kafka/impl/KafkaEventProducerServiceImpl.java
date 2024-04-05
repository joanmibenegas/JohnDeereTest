package johndeere.test.service.kafka.impl;

import johndeere.test.models.EventSessionDTO;
import johndeere.test.service.kafka.KafkaEventProducerService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Log
public class KafkaEventProducerServiceImpl implements KafkaEventProducerService {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaEventProducerServiceImpl.class);

    @Autowired
    KafkaTemplate<String, EventSessionDTO> kafkaTemplate;

    @Override
    public void send(String topicName, String key, EventSessionDTO value) {
        CompletableFuture<SendResult<String, EventSessionDTO>> future = kafkaTemplate.send(topicName, key, value);

        future.whenComplete((sendResult, exception) -> {
            if (exception != null) {
                future.completeExceptionally(exception);
            } else {
                future.complete(sendResult);
            }
            LOGGER.info("Event send to Kafka topic : " + value);
        });
    }
}
