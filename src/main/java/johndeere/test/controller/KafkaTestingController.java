package johndeere.test.controller;

import johndeere.test.models.TaskStatus;
import johndeere.test.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaTestingController {
    @Autowired
    KafkaProducerService kafkaProducerService;

    @PostMapping("/kafka-producer")
    public TaskStatus sendEvent() {
        TaskStatus test = new TaskStatus("1", "Test", 1L, TaskStatus.Status.STARTED );
        kafkaProducerService.send("event-topic", test.getTaskId(), test );
        return test;
    }
}
