package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "role")
public class RoleEntity implements Serializable {
    private long id;
    private String roleName;

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
