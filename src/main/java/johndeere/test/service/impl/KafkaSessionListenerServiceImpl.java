package johndeere.test.service.impl;

import johndeere.test.models.SessionDTO;
import johndeere.test.service.KafkaSessionListenerService;
import johndeere.test.service.SessionService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log
public class KafkaSessionListenerServiceImpl implements KafkaSessionListenerService {
    private final Logger logger = LoggerFactory.getLogger(KafkaSessionListenerServiceImpl.class);


    final SessionService sessionService;

    public KafkaSessionListenerServiceImpl(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    @KafkaListener(topics = {"session-topic"}, groupId = "task-group")
    public void consume(SessionDTO sessionDTO) {
        logger.info(String.format("Session listener triggered : " + sessionDTO));
        sessionService.manageSessionEntry(sessionDTO);
    }


}
