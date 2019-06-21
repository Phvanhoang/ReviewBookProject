package service_test;

import entity.RoleEntity;

import java.util.Set;

public interface UserRoleEntityService {
    Set<RoleEntity> findAllRoleByUserId(long id);
}
