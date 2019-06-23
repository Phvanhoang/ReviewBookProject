package repository;

import entity.MyBookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MyBookEntityRepositorry extends PagingAndSortingRepository<MyBookEntity, Long> {
    Page<MyBookEntity> findAllByUser(Pageable pageable, long userId);
}
