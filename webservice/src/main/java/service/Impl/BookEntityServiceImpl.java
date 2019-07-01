package service.Impl;

import entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.BookEntityRepository;
import service.BookEntityService;

import java.util.Optional;

public class BookEntityServiceImpl implements BookEntityService {
    @Autowired
    private BookEntityRepository bookEntityRepository;


    @Override
    public Page<BookEntity> findAll(Pageable pageable) {
        return bookEntityRepository.findAll(pageable);
    }

    @Override
    public Iterable<BookEntity> findAllByTitle(String title) {
        return bookEntityRepository.findAllByTitle(title);
    }

    @Override
    public BookEntity findById(long id) {
        Optional<BookEntity> bookEntity = bookEntityRepository.findById(id);
        if (bookEntity.isPresent()){
            return bookEntity.get();
        }
        return null;
    }

    @Override
    public void save(BookEntity bookEntity) {
        bookEntityRepository.save(bookEntity);
    }

    @Override
    public void delete(BookEntity bookEntity) {
        bookEntityRepository.delete(bookEntity);
    }
}
