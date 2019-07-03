package impl;

import entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.UserEntityRepository;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserEntityServiceImplTest {
    @Mock
    private UserEntityRepository repositoryMock;

    @Mock
    private UserEntity userMock;

    @InjectMocks
    private UserEntityServiceImpl userEntityService;

    @Test
    public void shouldVerifyThatSaveMethodOfRepositoryIsCalled_whenSaveIsCalled() {
        when(repositoryMock.save(userMock)).thenReturn(null);
        userEntityService.save(userMock);
        verify(repositoryMock).save(userMock);
    }

    @Test
    public void shouldVerifyThatDeleteMethodOfRepositoryIsCalled_whenDeleteIsCalled() {
        doNothing().when(repositoryMock).delete(userMock);
        userEntityService.delete(userMock);
        verify(repositoryMock).delete(userMock);
    }
}