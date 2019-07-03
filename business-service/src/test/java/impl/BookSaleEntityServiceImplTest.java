package impl;

import entity.BookSaleEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.BookSaleEntityRepository;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BookSaleEntityServiceImplTest {
    @Mock
    private BookSaleEntityRepository repositoryMock;

    @Mock
    private BookSaleEntity bookSaleMock;

    @InjectMocks
    private BookSaleEntityServiceImpl bookSaleEntityService;

    @Test
    public void shouldVerifyThatSaveMethodOfRepositoryIsCalled_whenSaveIsCalled() {
        when(repositoryMock.save(bookSaleMock)).thenReturn(null);
        bookSaleEntityService.save(bookSaleMock);
        verify(repositoryMock).save(bookSaleMock);
    }

    @Test
    public void shouldVerifyThatDeleteMethodOfRepositoryIsCalled_whenDeleteIsCalled() {
        doNothing().when(repositoryMock).delete(bookSaleMock);
        bookSaleEntityService.delete(bookSaleMock);
        verify(repositoryMock).delete(bookSaleMock);
    }
}