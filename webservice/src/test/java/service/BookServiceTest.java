package service;

import entity.BookEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import repository.BookEntityRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @Mock
    private BookEntityRepository bookEntityRepository;

    @InjectMocks
    private BookEntityServiceImpl bookEntityService = new BookEntityServiceImpl();

    @Test
    public void saveMethodTesting(){
        Mockito.when(bookEntityRepository.save(new BookEntity())).thenAnswer(new Answer<BookEntity>() {
            @Override
            public BookEntity answer(InvocationOnMock invocation) throws Throwable {
                Object[] aguments = invocation.getArguments();
                if (aguments != null && aguments.length > 0 && aguments[0] != null){
                     BookEntity book = (BookEntity) aguments[0];
                     book.setId(1);
                     return book;
                }
                return null;
            }
        });
        BookEntity book = new BookEntity();
        bookEntityService.save(book);
        Assert.assertEquals(book.getId(), 1);
    }
}
