package Hotel.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "log_in")
public class UserSignIn implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToOne
    @JoinColumn(name = "id_khach_hang")
    private Customer customer;
    @Column(name = "user_name", length = 50)
    private String username;
    @Column(name = "pass_word", length = 50)
    private String password;

    public UserSignIn() {
    }

    public UserSignIn(Customer customer, String username, String password)  {
        this.customer = customer;
        this.username = username;
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setUserID(Customer customer) {
        this.customer = customer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
