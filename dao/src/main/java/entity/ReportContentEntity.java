package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "report_content")
public class ReportContentEntity implements Serializable {
    private long id;
    private String name;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
