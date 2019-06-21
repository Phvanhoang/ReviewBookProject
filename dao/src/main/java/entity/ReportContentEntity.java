package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "report_content")
public class ReportContentEntity implements Serializable {
    private long id;
    private String content;

    public ReportContentEntity() {
    }

    @Id
    @Column(name = "report_content_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "report_content")
    public String getcontent() {
        return content;
    }

    public void setcontent(String content) {
        this.content = content;
    }
}
