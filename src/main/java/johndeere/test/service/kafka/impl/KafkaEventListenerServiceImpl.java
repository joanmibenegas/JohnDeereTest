package johndeere.test.service.kafka.impl;

import johndeere.test.entity.SessionEntity;
import johndeere.test.models.EventSessionDTO;
import johndeere.test.service.EventService;
import johndeere.test.service.SessionService;
import johndeere.test.service.kafka.KafkaEventListenerService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Log
public class KafkaEventListenerServiceImpl implements KafkaEventListenerService {
    private final Logger logger = LoggerFactory.getLogger(KafkaEventListenerServiceImpl.class);


    final SessionService sessionService;
    final EventService eventService;
    public KafkaEventListenerServiceImpl(SessionService sessionService, EventService eventService) {
        this.sessionService = sessionService;
        this.eventService = eventService;
    }

    @Override
    @KafkaListener(topics = {"event-topic"}, groupId = "task-group")
    public void consume(EventSessionDTO eventSessionDTO) {
        Optional<SessionEntity> session = sessionService.findSessionById(eventSessionDTO.getSessionId());
        if(session.isPresent()) {
           eventService.manageNewEvents(eventSessionDTO);
        }
    }


}
