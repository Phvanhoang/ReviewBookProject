package impl;

import entity.RoleEntity;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.UserEntityRepository;
import service.UserEntityService;
import service.UserRoleEntityService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserEntityServiceImpl implements UserEntityService {
    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserRoleEntityService userRoleEntityService;

    @Override
    public Page<UserEntity> findAll(Pageable pageable) {
        return userEntityRepository.findAll(pageable);
    }

    @Override
    public UserEntity findById(long id) {
        Optional<UserEntity> userEntity = userEntityRepository.findById(id);
        if (userEntity.isPresent()) {
            return userEntity.get();
        }
        return null;
    }

    @Override
    public void save(UserEntity userEntity) {
        userEntityRepository.save(userEntity);
    }

    @Override
    public void delete(UserEntity userEntity) {
        userEntityRepository.delete(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userEntityRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User" + username + "was not found in the database");
        }
        Set<RoleEntity> roles = userRoleEntityService.findAllRoleByUserId(userEntity.getId());
        Set<String> roleNames = new HashSet<>();
        for (RoleEntity role : roles) {
            roleNames.add(role.getRoleName());
        }
        Set<GrantedAuthority> grantedList = new HashSet<>();
        if (roleNames.size() != 0) {
            for (String roleName : roleNames) {
                grantedList.add(new SimpleGrantedAuthority(roleName));
            }
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), grantedList);
    }
}
