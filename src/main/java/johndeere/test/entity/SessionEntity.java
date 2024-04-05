package johndeere.test.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SessionEntity {

    @Id
    private String sessionId;

    private String machineId;

    private Timestamp startAt;

    @Nullable
    private Timestamp endDate;
}
