package johndeere.test.repository;

import johndeere.test.entity.MachineSessionEntity;
import johndeere.test.entity.MachineSessionIdKey;
import org.springframework.data.repository.CrudRepository;

public interface MachineSessionRepository  extends CrudRepository<MachineSessionEntity, MachineSessionIdKey> {
}
