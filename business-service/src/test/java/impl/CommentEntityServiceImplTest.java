package impl;

import entity.CommentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.CommentEntityRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CommentEntityServiceImplTest {
    @Mock
    private CommentEntityRepository repositoryMock;

    @Mock
    private CommentEntity commentMock;

    @InjectMocks
    private CommentEntityServiceImpl commentEntityService;

    @Test
    public void shouldVerifyThatSaveMethodOfRepositoryIsCalled_whenSaveIsCalled() {
        when(repositoryMock.save(commentMock)).thenReturn(null);
        commentEntityService.save(commentMock);
        verify(repositoryMock).save(commentMock);
    }

    @Test
    public void shouldVerifyThatDeleteMethodOfRepositoryIsCalled_whenDeleteIsCalled() {
        doNothing().when(repositoryMock).delete(commentMock);
        commentEntityService.delete(commentMock);
        verify(repositoryMock).delete(commentMock);
    }
}