package service_test;

import entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BookEntityService {
    Page<BookEntity> findAll(Pageable pageable);
    Iterable<BookEntity> findAllByName(String name);
    BookEntity findById(long id);
    void save(BookEntity bookEntity);
    void delete(BookEntity bookEntity);
}
