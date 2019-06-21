package service_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;
import repository.BookEntityRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @Mock
    private BookEntityRepository bookEntityRepository;

    @InjectMocks
    private BookEntityServiceImpl bookEntityService;

    @Test
    public void findAllTesting(){
        Mockito.verify(bookEntityRepository).findAll(Pageable.unpaged());
        
    }
}
