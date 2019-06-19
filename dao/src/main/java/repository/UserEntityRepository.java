package repository;

import entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserEntityRepository extends PagingAndSortingRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
