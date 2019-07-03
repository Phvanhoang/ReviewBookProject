package service;

import entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface BookEntityService {
    Page<BookEntity> findAll(Pageable pageable);

    Iterable<BookEntity> findAllByTitle(String title);

    BookEntity findById(long id);

    void save(BookEntity bookEntity);

    void delete(BookEntity bookEntity);
}
