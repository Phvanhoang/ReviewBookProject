package repository;

import entity.MyBooksEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MyBookEntityRepository extends PagingAndSortingRepository<MyBooksEntity, Long> {
}
