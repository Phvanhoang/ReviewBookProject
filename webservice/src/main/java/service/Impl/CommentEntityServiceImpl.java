package service.Impl;

import entity.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.CommentEntityRepository;
import service.CommentEntityService;

import java.util.Set;

public class CommentEntityServiceImpl implements CommentEntityService {
    @Autowired
    private CommentEntityRepository commentEntityRepository;


    @Override
    public Page<CommentEntity> findAllByBook(Pageable pageable, long bookId) {
        return commentEntityRepository.findAllByBook(pageable, bookId);
    }

    @Override
    public Set<CommentEntity> findAllByComment(String commentId) {
        return commentEntityRepository.findAllByComment(commentId);
    }

    @Override
    public void save(CommentEntity commentEntity) {
        commentEntityRepository.save(commentEntity);
    }

    @Override
    public void delete(CommentEntity commentEntity) {
        commentEntityRepository.delete(commentEntity);
    }
}
