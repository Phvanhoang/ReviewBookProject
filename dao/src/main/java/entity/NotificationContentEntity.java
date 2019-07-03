package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notification_content")
public class NotificationContentEntity implements Serializable {
    private int id;
    private String content;

    public NotificationContentEntity() {
    }

    @Id
    @Column(name = "notification_content_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "notification_content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
