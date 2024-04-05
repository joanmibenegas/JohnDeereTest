package johndeere.test.service;

import johndeere.test.entity.EventEntity;
import johndeere.test.models.EventSessionDTO;

import java.util.List;

public interface EventService {

    void manageNewEvents(EventSessionDTO eventSessionDTO);

    List<EventEntity> listEventsByIdMachineIdSession(String idMachine, String idSession);
}
