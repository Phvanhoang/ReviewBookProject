package service.Impl;

import entity.CommentReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CommentReportEntityRepository;
import service.CommentReportEntityService;

public class CommentReportEntityServiceImpl implements CommentReportEntityService {
    @Autowired
    private CommentReportEntityRepository commentReportEntityRepository;
    @Override
    public Iterable<CommentReportEntity> findAll() {
        return commentReportEntityRepository.findAll();
    }

    @Override
    public void save(CommentReportEntity entity) {
        commentReportEntityRepository.save(entity);
    }
}
