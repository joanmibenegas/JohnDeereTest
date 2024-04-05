package johndeere.test.service;

import johndeere.test.entity.SessionEntity;
import johndeere.test.models.SessionDTO;

import java.util.Optional;

public interface SessionService {
    void manageSessionEntry(SessionDTO sessionDto);

    Optional<SessionEntity> findSessionById(String idSession);
}
