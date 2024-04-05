package johndeere.test.repository;

import johndeere.test.entity.MachineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends CrudRepository<MachineEntity, String> {
}
