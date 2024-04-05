package johndeere.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class SessionEntity {

    @Id
    private String sessionId;

    private String machineId;

    private Timestamp startAt;

    private Timestamp endDate;
}
