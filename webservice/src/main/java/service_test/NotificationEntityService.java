package service_test;

import entity.NotificationEntity;

import java.util.Set;

public interface NotificationEntityService {
    Set<NotificationEntity> findAllByUser(long id);
}
