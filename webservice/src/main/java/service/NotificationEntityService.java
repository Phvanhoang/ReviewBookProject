package service;

import entity.NotificationEntity;

import java.util.List;
import java.util.Set;

public interface NotificationEntityService {
    Set<NotificationEntity> findAllByUser(long id);
}
