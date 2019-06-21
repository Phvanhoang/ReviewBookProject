package service_test;

import entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserEntityService extends UserDetailsService{
    Page<UserEntity> findAll(Pageable pageable);
    UserEntity findById(long id);
    void save(UserEntity userEntity);
    void delete(UserEntity userEntity);
}
