package johndeere.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {
    @Autowired
    KafkaTemplate kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       // kafkaTemplate.send("event-topic", "taskId", new TaskStatus("taskId", "taskName", 50.0f, TaskStatus.Status.RUNNING));
       // kafkaTemplate.send("event-topic", "taskId", new TaskStatus("taskId", "taskName", 100.0f, TaskStatus.Status.FINISHED));
    }

}
