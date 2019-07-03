package impl;

import entity.CommentReportEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.CommentReportEntityRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CommentReportEntityServiceImplTest {

    @Mock
    private CommentReportEntityRepository repositoryMock;

    @Mock
    private CommentReportEntity commentReportMock;

    @InjectMocks
    private CommentReportEntityServiceImpl commentReportEntityService;

    @Test
    public void shouldVerifyThatSaveMethodOfRepositoryIsCalled_whenSaveIsCalled() {
        when(repositoryMock.save(commentReportMock)).thenReturn(null);
        commentReportEntityService.save(commentReportMock);
        verify(repositoryMock).save(commentReportMock);
    }
}