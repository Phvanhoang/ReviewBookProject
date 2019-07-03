package service;

import entity.NotificationContentEntity;

public interface NotificationContentEntityService {
    Iterable<NotificationContentEntity> findAll();
}
