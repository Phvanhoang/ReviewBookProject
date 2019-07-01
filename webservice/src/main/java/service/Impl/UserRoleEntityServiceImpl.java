package service.Impl;

import entity.RoleEntity;
import entity.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRoleEntityRepository;
import service.UserRoleEntityService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRoleEntityServiceImpl implements UserRoleEntityService {
    @Autowired
    private UserRoleEntityRepository roleEntityRepository;

    @Override
    public Set<RoleEntity> findAllRoleByUserId(long id) {
        Set<UserRoleEntity> userRoleEntityList = (Set<UserRoleEntity>) roleEntityRepository.findAll();
        Set<UserRoleEntity> userRoleEntities = userRoleEntityList.stream().filter(userRole -> userRole.getId() == id).collect(Collectors.toSet());
        Set<RoleEntity> roleEntityList = new HashSet<>();
        userRoleEntities.forEach(userRoleEntity -> roleEntityList.add(userRoleEntity.getRole()));
        return roleEntityList;
    }
}
