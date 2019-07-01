package service.Impl;

import entity.BookSaleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import repository.BookSaleEntityRepository;
import service.BookSaleEntityService;

public class BookSaleEntityServiceImpl implements BookSaleEntityService {
    @Autowired
    private BookSaleEntityRepository bookSaleEntityRepository;

    @Override
    public Iterable<BookSaleEntity> findAll() {
        return bookSaleEntityRepository.findAll();
    }

    @Override
    public void save(BookSaleEntity bookSaleEntity) {
        bookSaleEntityRepository.save(bookSaleEntity);
    }

    @Override
    public void delete(BookSaleEntity bookSaleEntity) {
        bookSaleEntityRepository.delete(bookSaleEntity);
    }
}
