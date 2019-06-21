package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book_sale")
public class BookSaleEntity implements Serializable {
    private long id;
    private DistributorEntity distributorEntity;
    private BookEntity book;
    private String url;
    private float price;

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
    public DistributorEntity getDistributorEntity() {
        return distributorEntity;
    }

    public void setDistributorEntity(DistributorEntity distributorEntity) {
        this.distributorEntity = distributorEntity;
    }

    @OneToOne(fetch =  FetchType.LAZY)
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

    @Column(name = "price")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
