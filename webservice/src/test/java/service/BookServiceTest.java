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
import service.Impl.BookEntityServiceImpl;

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
                Object[] arguments = invocation.getArguments();
                if (arguments != null && arguments.length > 0 && arguments[0] != null){
                    BookEntity book = (BookEntity) arguments[0];
                    book.setId(1);
                    System.out.println(book);
                    return book;
                }
                return null;
            }
        });
        BookEntity book = new BookEntity();
        bookEntityService.save(book);
        Assert.assertEquals(book.getId(), 0);
    }
}
