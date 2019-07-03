package entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

    private long id;
    private String username;
    private String password;
    private boolean accountNonLocked;
    private boolean enable;
    private String firstName;
    private String lastName;
    private Date birthday;
    private boolean sex;
    private String email;
    private String phoneNumber;
    private String address;
    private Set<MyBooksEntity> myBooks = new HashSet<>();

    public UserEntity() {
    }

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "username")
    @NotBlank
    @Size(min = 3)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    @NotBlank
    @Size(min = 8)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }

    @Column(name = "account_non_locked")
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Column(name = "enable")
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Column(name = "first_name")
    @NotBlank
    @Size(min = 2, max = 9)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    @NotBlank
    @Size(max = 9)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "birthday")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy/MM/dd")
    @Future
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column(name = "sex")
    @NotNull
    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Column(name = "email")
    @NotBlank
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone_number")
    @NotBlank
    @Pattern(regexp = "^0[0-9]{9}")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "address")
    @Pattern(regexp = "[\\s,]{2,}\\s")
    @NotBlank
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<MyBooksEntity> getMyBooks() {
        return myBooks;
    }

    public void setMyBooks(Set<MyBooksEntity> myBooks) {
        this.myBooks = myBooks;
    }
}
