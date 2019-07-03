package service;

import entity.RoleEntity;

import java.util.List;
import java.util.Set;

public interface UserRoleEntityService {
    Set<RoleEntity> findAllRoleByUserId(long id);
}
