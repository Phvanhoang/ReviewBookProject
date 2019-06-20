package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comment")
public class CommentEntity implements Serializable {
    private String id;
    private UserEntity user;
    private BookEntity book;
    private CommentEntity comment;
    private String content;
    private Set<CommentEntity> replies = new HashSet<>();

    public CommentEntity() {
    }

    @Id
    @Column(name = "comment_id")
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
    @JoinColumn(name = "book_id", nullable = false)
    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    @Column(name = "comment_content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_comment_id", nullable = false)
    public CommentEntity getComment() {
        return comment;
    }

    public void setComment(CommentEntity comment) {
        this.comment = comment;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comment")
    public Set<CommentEntity> getReplies() {
        return replies;
    }

    public void setReplies(Set<CommentEntity> replies) {
        this.replies = replies;
    }
}
