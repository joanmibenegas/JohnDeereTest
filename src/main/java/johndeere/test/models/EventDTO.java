package johndeere.test.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class EventDTO {
    private Timestamp eventAt;
    private String eventType;
    private BigDecimal numericEventValue;
}
