package impl;

import entity.BookEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.BookEntityRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(value = MockitoJUnitRunner.class)
public class BookEntityServiceImplTest {

    @Mock
    private BookEntityRepository repositoryMock;

    @Mock
    private BookEntity bookMock;

    @InjectMocks
    private BookEntityServiceImpl bookEntityService;

    @Test
    public void shouldReturnBookEntity_whenFindByIdIsCalled() {
        when(repositoryMock.findById(1234L)).thenReturn(Optional.of(bookMock));
        BookEntity retrieveBook = bookEntityService.findById(1234L);
        assertEquals(retrieveBook, bookMock);
    }

    @Test
    public void shouldVerifyThatSaveMethodOfRepositoryIsCalled_whenSaveIsCalled() {
        when(repositoryMock.save(bookMock)).thenReturn(null);
        bookEntityService.save(bookMock);
        verify(repositoryMock).save(bookMock);
    }

    @Test
    public void shouldVerifyThatDeleteMethodOfRepositoryIsCalled_whenDeleteIsCalled() {
        doNothing().when(repositoryMock).delete(bookMock);
        bookEntityService.delete(bookMock);
        verify(repositoryMock).delete(bookMock);
    }
}