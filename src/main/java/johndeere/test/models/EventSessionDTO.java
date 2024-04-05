package johndeere.test.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EventSessionDTO {
    private String sessionId;
    private List<EventDTO> events;
}
