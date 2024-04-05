package johndeere.test.repository;

import johndeere.test.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, String> {
    List<EventEntity> findBySessionId(String sessionId);
}
