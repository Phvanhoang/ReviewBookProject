package service;

import entity.NotificationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import repository.NotificationEntityRepository;

import java.util.Set;

public class NotificationEntityServiceImpl implements NotificationEntityService {
    @Autowired
    private NotificationEntityRepository notificationEntityRepository;

    @Override
    public Set<NotificationEntity> findAllByUser(long id) {
        return notificationEntityRepository.findAllByUser(id);
    }
}
