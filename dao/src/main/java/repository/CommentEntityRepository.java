package repository;

import entity.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Set;

public interface CommentEntityRepository extends PagingAndSortingRepository<CommentEntity, Long> {
    Page<CommentEntity> findAllByBook(Pageable pageable, long bookId);

    Set<CommentEntity> findAllByComment(long commentId);
}