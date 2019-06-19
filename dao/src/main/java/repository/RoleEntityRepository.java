package repository;

import entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleEntityRepository extends CrudRepository<RoleEntity, Long> {
}
