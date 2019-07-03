package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "distributor")
public class DistributorEntity implements Serializable {
    private long id;
    private String name;

    public DistributorEntity() {
    }

    @Id
    @Column(name = "distributor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "distributor_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
