package Hotel.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_USers")
public class UserSignIn {
    @Id
    @Column(name = "UserID", nullable = false, unique = true)
    private int userID;
    @Column(name = "full_name", length = 50)
    private String fullName;
    @Column(name = "user_name", length = 50)
    private String username;
    @Column(name = "pass_wd", length = 50)
    private String password;

    public UserSignIn() {
    }

    public UserSignIn(int userID, String fullName, String username, String password) {
        this.userID = userID;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
