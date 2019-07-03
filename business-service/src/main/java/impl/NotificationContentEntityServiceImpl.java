package impl;

import entity.NotificationContentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import repository.NotificationContentEntityRepository;
import service.NotificationContentEntityService;

public class NotificationContentEntityServiceImpl implements NotificationContentEntityService {
    @Autowired
    private NotificationContentEntityRepository notificationContentEntityRepository;

    @Override
    public Iterable<NotificationContentEntity> findAll() {
        return notificationContentEntityRepository.findAll();
    }
}
