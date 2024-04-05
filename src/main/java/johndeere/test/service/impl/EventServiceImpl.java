package johndeere.test.service.impl;

import jakarta.transaction.Transactional;
import johndeere.test.entity.EventEntity;
import johndeere.test.entity.MachineEntity;
import johndeere.test.entity.MachineSessionIdKey;
import johndeere.test.entity.SessionEntity;
import johndeere.test.models.EventDTO;
import johndeere.test.models.EventSessionDTO;
import johndeere.test.repository.EventRepository;
import johndeere.test.repository.MachineSessionRepository;
import johndeere.test.service.EventService;
import johndeere.test.service.MachineService;
import johndeere.test.service.SessionService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log
public class EventServiceImpl implements EventService {
    private final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);
    final EventRepository eventSessionRepository;
    final SessionService sessionService;
    final MachineService machineService;
    final MachineSessionRepository machineSessionRepository;

    EventServiceImpl(EventRepository eventSessionRepository, SessionService sessionService, MachineService machineService, MachineSessionRepository machineSessionRepository) {
        this.eventSessionRepository = eventSessionRepository;
        this.sessionService = sessionService;
        this.machineService = machineService;
        this.machineSessionRepository = machineSessionRepository;
    }

    @Override
    @Transactional
    public void manageNewEvents(EventSessionDTO eventSessionDTO) {
        logger.info("CREATING EVENTS...");
        eventSessionDTO.getEvents().forEach(event -> {
            createNewEventDTO(event, eventSessionDTO.getSessionId());
        });
        logger.info("EVENTS CREATED...");
    }

    private void createNewEventDTO(EventDTO eventDTO, String sessionId) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setSessionId(sessionId);
        eventEntity.setEventType(eventDTO.getEventType());
        eventEntity.setNumericEventValue(eventDTO.getNumericEventValue());
        eventEntity.setEventAt(eventDTO.getEventAt());
        logger.info("EVENT -> " + eventEntity);
        eventSessionRepository.save(eventEntity);
    }

    @Override
    public List<EventEntity> listEventsByIdMachineIdSession(String idMachine, String idSession) {

        Optional<SessionEntity> sessionEntity = sessionService.findSessionById(idSession);
        Optional<MachineEntity> machineEntity = machineService.findMachineById(idMachine);

            if( machineEntity.isPresent() && sessionEntity.isPresent()) {
                MachineSessionIdKey machineSessionIdKey = new MachineSessionIdKey(sessionEntity.get(), machineEntity.get());
                machineSessionRepository.findById(machineSessionIdKey);
               return eventSessionRepository.findBySessionId(sessionEntity.get().getSessionId());
            }
        return new ArrayList<>();
    }

}
