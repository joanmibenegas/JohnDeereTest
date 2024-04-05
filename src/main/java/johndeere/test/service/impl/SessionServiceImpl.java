package johndeere.test.service.impl;

import johndeere.test.entity.SessionEntity;
import johndeere.test.models.SessionDTO;
import johndeere.test.repository.SessionRepository;
import johndeere.test.service.SessionService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@Log
public class SessionServiceImpl implements SessionService {
    private final Logger logger = LoggerFactory.getLogger(SessionServiceImpl.class);
    final SessionRepository sessionRepository;

    SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void manageSessionEntry(SessionDTO sessionDto) {
        SessionEntity session = sessionRepository.findByMachineId(sessionDto.getMachineId());

        if(session != null) {
           finalizeSession(session);
        } else {
            createSession(sessionDto);
        }
    }

    private void finalizeSession(SessionEntity session) {
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        session.setEndDate(new Timestamp(timeStampMillis));
        SessionEntity sessionEntity = sessionRepository.save(session);
        logger.info("Session saved: " + sessionEntity);
    }

    private void createSession(SessionDTO sessionDTO) {
       SessionEntity sessionEntity = new SessionEntity(sessionDTO.getSessionId(), sessionDTO.getMachineId(), sessionDTO.getStartAt(), null);
        sessionRepository.save(sessionEntity);
        logger.info("Session created: " + sessionEntity);
    }
}
