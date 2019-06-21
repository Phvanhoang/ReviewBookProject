package service_test;

import entity.NotificationContentEntity;

public interface NotificationContentEntityService {
    Iterable<NotificationContentEntity> findAll();
}
