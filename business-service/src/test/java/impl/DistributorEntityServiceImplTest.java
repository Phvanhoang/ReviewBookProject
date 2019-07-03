package impl;

import entity.DistributorEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.DistributorEntityRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DistributorEntityServiceImplTest {
    @Mock
    private DistributorEntityRepository repositoryMock;

    @Mock
    private DistributorEntity distributeMock;

    @InjectMocks
    private DistributorEntityServiceImpl distributeEntityService;

    @Test
    public void shouldVerifyThatSaveMethodOfRepositoryIsCalled_whenSaveIsCalled() {
        when(repositoryMock.save(distributeMock)).thenReturn(null);
        distributeEntityService.save(distributeMock);
        verify(repositoryMock).save(distributeMock);
    }
}