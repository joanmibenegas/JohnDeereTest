package johndeere.test.service.impl;

import johndeere.test.models.base.BaseDTO;
import johndeere.test.service.KafkaProducerService;
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
public class KafkaSessionProducerServiceImpl implements KafkaProducerService {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaSessionProducerServiceImpl.class);

    @Autowired
    KafkaTemplate<String, BaseDTO> kafkaTemplate;

    @Override
    public void send(String topicName, String key, BaseDTO value) {
        CompletableFuture<SendResult<String, BaseDTO>> future = kafkaTemplate.send(topicName, key, value);

        future.whenComplete((sendResult, exception) -> {
            if (exception != null) {
                future.completeExceptionally(exception);
            } else {
                future.complete(sendResult);
            }
            LOGGER.info("Session send to Kafka topic : " + value);
        });
    }
}
