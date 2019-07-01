package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comment_report")
public class CommentReportEntity implements Serializable {
    private long id;
    private ReportContentEntity reportContent;
    private CommentEntity comment;
    private boolean nonInspected;

    public CommentReportEntity() {
    }

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
    public ReportContentEntity getReportContent() {
        return reportContent;
    }

    public void setReportContent(ReportContentEntity reportContent) {
        this.reportContent = reportContent;
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
