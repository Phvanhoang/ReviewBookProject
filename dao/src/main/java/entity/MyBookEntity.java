package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "my_book")
public class MyBookEntity {
    private UserEntity user;
    private Set<BookEntity> book = new HashSet<>();

    public MyBookEntity() {
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    public Set<BookEntity> getBook() {
        return book;
    }

    public void setBook(Set<BookEntity> book) {
        this.book = book;
    }
}
