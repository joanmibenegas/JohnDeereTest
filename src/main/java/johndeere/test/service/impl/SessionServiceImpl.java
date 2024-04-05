package johndeere.test.service.impl;

import johndeere.test.entity.MachineEntity;
import johndeere.test.entity.SessionEntity;
import johndeere.test.models.SessionDTO;
import johndeere.test.repository.SessionRepository;
import johndeere.test.service.MachineService;
import johndeere.test.service.SessionService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@Service
@Log
public class SessionServiceImpl implements SessionService {
    private final Logger logger = LoggerFactory.getLogger(SessionServiceImpl.class);
    final SessionRepository sessionRepository;
    final MachineService machineService;

    SessionServiceImpl(SessionRepository sessionRepository, MachineService machineService) {
        this.sessionRepository = sessionRepository;
        this.machineService = machineService;
    }

    @Override
    public void manageSessionEntry(SessionDTO sessionDto) {
        Optional<SessionEntity> sessionEntity = sessionRepository.findById(sessionDto.getSessionId());
        Optional<MachineEntity> machineEntity = machineService.findMachineById(sessionDto.getMachineId());

        if( machineEntity.isPresent() && sessionEntity.isPresent()) {
           finalizeSession(sessionRepository.findById(sessionDto.getSessionId()).get());
        } else {
            machineService.createMachine(sessionDto.getMachineId());
            createSession(sessionDto);
        }
    }

    @Override
    public Optional<SessionEntity> findSessionById(String idSession) {
        return sessionRepository.findById(idSession);
    }

    private void finalizeSession(SessionEntity session) {
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        session.setEndDate(new Timestamp(timeStampMillis));
        SessionEntity sessionEntity = sessionRepository.save(session);
        logger.info("Session saved: " + sessionEntity);
    }

    private void createSession(SessionDTO sessionDTO) {
       SessionEntity sessionEntity = new SessionEntity(sessionDTO.getSessionId(), sessionDTO.getStartAt(), null);
        sessionRepository.save(sessionEntity);
        logger.info("Session created: " + sessionEntity);
    }
}
