package repository;

import entity.MyBooksEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MyBookEntityRepositorry extends PagingAndSortingRepository<MyBooksEntity, Long> {
    Page<MyBooksEntity> findAllByUser(Pageable pageable, long userId);
}
