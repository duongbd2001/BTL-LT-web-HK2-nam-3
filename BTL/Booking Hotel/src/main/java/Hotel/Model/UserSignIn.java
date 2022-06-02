package Hotel.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log_in")
public class UserSignIn {
    @Id
    @Column(name = "id_khach_hang", nullable = false, unique = true)
    private int userID;
    @Column(name = "user_name", length = 50)
    private String username;
    @Column(name = "pass_word", length = 50)
    private String password;

    public UserSignIn() {
    }

    public UserSignIn(int userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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
