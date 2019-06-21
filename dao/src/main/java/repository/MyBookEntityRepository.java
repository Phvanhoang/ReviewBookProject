package repository;

import entity.MyBookEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MyBookEntityRepository extends PagingAndSortingRepository<MyBookEntity, Long> {
}
