package entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class BookEntity implements Serializable {
    private long id;
    private String title;
    private String content;
    private String genre;
    private String authors;
    private String image;
    private Date date;
    private float rate;
    private Set<CommentEntity> comments = new HashSet<>();
    private Set<BookSaleEntity> bookSaleEntities = new HashSet<>();

    public BookEntity() {
    }

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "book_title")
    @NotBlank
    @Size(min = 5)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "book_content")
    @NotBlank
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "type_book")
    @NotBlank
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @NotBlank
    @Column(name = "authors")
    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @NotBlank
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy/MM/dd")
    @Future
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "rate")
    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "book")
    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    public Set<BookSaleEntity> getBookSaleEntities() {
        return bookSaleEntities;
    }

    public void setBookSaleEntities(Set<BookSaleEntity> bookSaleEntities) {
        this.bookSaleEntities = bookSaleEntities;
    }
}