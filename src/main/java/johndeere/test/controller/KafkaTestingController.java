package johndeere.test.controller;

import johndeere.test.models.SessionDTO;
import johndeere.test.service.KafkaSessionProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaTestingController {
    final
    KafkaSessionProducerService kafkaProducerService;

    public KafkaTestingController(KafkaSessionProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> sendEvent(@RequestBody SessionDTO sessionDTO) {
        kafkaProducerService.send("session-topic", sessionDTO.getSessionId(), sessionDTO );
        return ResponseEntity.ok().build();
    }
}
