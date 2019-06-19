package repository;

import entity.BookSaleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface BookSaleEntityRepository extends CrudRepository<BookSaleEntity, Long> {
    Set<BookSaleEntity> findAllByBook(long bookId);
}
