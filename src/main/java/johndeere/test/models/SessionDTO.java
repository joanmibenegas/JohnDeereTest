package johndeere.test.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class SessionDTO implements Serializable {
    private String sessionId;
    private String machineId;
    private Timestamp startAt;
}
