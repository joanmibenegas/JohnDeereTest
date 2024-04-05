package johndeere.test.models;

import johndeere.test.models.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class SessionDTO implements Serializable, BaseDTO {
    private String sessionId;
    private String machineId;
    private Timestamp startAt;
}
