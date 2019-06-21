package service_test;

import entity.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface CommentEntityService {
    Page<CommentEntity> findAllByBook(Pageable pageable, long bookId);
    Set<CommentEntity> findAllByComment(String commentId);
    void save(CommentEntity commentEntity);
    void delete(CommentEntity commentEntity);
}