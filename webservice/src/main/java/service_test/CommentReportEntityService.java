package service_test;

import entity.CommentReportEntity;

public interface CommentReportEntityService {
    Iterable<CommentReportEntity> findAll();
    void save(CommentReportEntity entity);
}
