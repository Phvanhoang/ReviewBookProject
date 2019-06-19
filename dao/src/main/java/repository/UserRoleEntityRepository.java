package repository;

import entity.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UserRoleEntityRepository extends CrudRepository<UserRoleEntity, Long> {
    Set<UserRoleEntity> findAllByUser(long userId);
}
