package service;

import entity.CommentReportEntity;

public interface CommentReportEntityService {
    Iterable<CommentReportEntity> findAll();
    void save(CommentReportEntity entity);
}
