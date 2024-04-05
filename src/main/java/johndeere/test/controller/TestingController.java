package johndeere.test.controller;

import johndeere.test.entity.EventEntity;
import johndeere.test.models.EventSessionDTO;
import johndeere.test.models.SessionDTO;
import johndeere.test.service.EventService;
import johndeere.test.service.kafka.KafkaEventProducerService;
import johndeere.test.service.kafka.KafkaSessionProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestingController {
    final
    KafkaSessionProducerService kafkaSessionProducerService;

    final KafkaEventProducerService kafkaEventProducerService;

    final EventService eventService;


    public TestingController(KafkaSessionProducerService kafkaSessionProducerService, KafkaEventProducerService kafkaEventProducerService, EventService eventService) {
        this.kafkaSessionProducerService = kafkaSessionProducerService;
        this.kafkaEventProducerService = kafkaEventProducerService;
        this.eventService = eventService;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> sendEvent(@RequestBody SessionDTO sessionDTO) {
        kafkaSessionProducerService.send("session-topic", sessionDTO.getSessionId(), sessionDTO );
        return ResponseEntity.ok().build();
    }

    @PostMapping("/event")
    public ResponseEntity<Void> sendEvent(@RequestBody EventSessionDTO event) {
        kafkaEventProducerService.send("event-topic", event.getSessionId(), event );
        return ResponseEntity.ok().build();
    }

    @GetMapping("/machine/{idMachine}/session/{idSession}")
    public ResponseEntity<List<EventEntity>> getEventsByMachineIdSessionId(@PathVariable("idMachine") String idMachine,
                                                           @PathVariable("idSession") String idSession) {
        return ResponseEntity.ok(eventService.listEventsByIdMachineIdSession(idMachine, idSession));
    }
}
