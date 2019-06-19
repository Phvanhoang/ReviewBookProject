package repository;

import entity.NotificationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface NotificationEntityRepository extends CrudRepository<NotificationEntity, String> {
    Set<NotificationEntity> findAllByUser(long id);
}
