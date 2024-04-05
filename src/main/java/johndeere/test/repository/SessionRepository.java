package johndeere.test.repository;

import johndeere.test.entity.SessionEntity;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<SessionEntity, String> {
    SessionEntity findByMachineId(String machineId);
}
