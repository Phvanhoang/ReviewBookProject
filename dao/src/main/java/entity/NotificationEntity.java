package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notification")
public class NotificationEntity implements Serializable {
    private String id;
    private UserEntity user;
    private CommentEntity comment;
    private NotificationContentEntity content;
    private String url;

    public NotificationEntity() {
    }

    @Id
    @Column(name = "no_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false)
    public CommentEntity getComment() {
        return comment;
    }

    public void setComment(CommentEntity comment) {
        this.comment = comment;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_content_id")
    public NotificationContentEntity getContent() {
        return content;
    }

    public void setContent(NotificationContentEntity content) {
        this.content = content;
    }

    @Column(name = "no_url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = "http://localhost:8080/";
    }
}
