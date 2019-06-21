package service_test;

import entity.NotificationContentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import repository.NotificationContentEntityRepository;

public class NotificationContentEntityServiceImpl implements NotificationContentEntityService {
    @Autowired
    private NotificationContentEntityRepository notificationContentEntityRepository;

    @Override
    public Iterable<NotificationContentEntity> findAll() {
        return notificationContentEntityRepository.findAll();
    }
}
