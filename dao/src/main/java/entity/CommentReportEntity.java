package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comment_report")
public class CommentReportEntity implements Serializable {
    private long id;
    private ReportContentEntity reportContentEntity;
    private CommentEntity comment;
    private boolean nonInspected;

    @Id
    @Column(name = "comment_report_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_content_id")
    public ReportContentEntity getReportContentEntity() {
        return reportContentEntity;
    }

    public void setReportContentEntity(ReportContentEntity reportContentEntity) {
        this.reportContentEntity = reportContentEntity;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    public CommentEntity getComment() {
        return comment;
    }

    public void setComment(CommentEntity comment) {
        this.comment = comment;
    }

    @Column(name = "non_inspected")
    public boolean isNonInspected() {
        return nonInspected;
    }

    public void setNonInspected(boolean nonInspected) {
        this.nonInspected = nonInspected;
    }
}
