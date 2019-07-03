package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book_sale")
public class BookSaleEntity implements Serializable {
    private long id;
    private DistributorEntity distributor;
    private BookEntity book;
    private String url;

    public BookSaleEntity() {
    }

    @Id
    @Column(name = "book_sale_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distributor_id")
    public DistributorEntity getDistributor() {
        return distributor;
    }

    public void setDistributor(DistributorEntity distributor) {
        this.distributor = distributor;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    @Column(name = "book_sale_url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
