package repository;

import entity.BookEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookEntityRepository extends PagingAndSortingRepository<BookEntity, Long> {
    Iterable<BookEntity> findAllByName(String name);
}
