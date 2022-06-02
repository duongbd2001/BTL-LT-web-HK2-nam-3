package Hotel.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khach_hang")
public class Customer {
    @Id
    @Column(name = "id_khach_hang", nullable = false, unique = true)
    public int id;
    @Column(name = "ho_ten", nullable = false, length = 50)
    public String name;
    @Column(name = "cccd", nullable = false)
    public long citizenIdentification;    //Can cuoc cong dan
    @Column(name = "sdt", length = 20)
    public String phoneNumber;
    @Column(name = "email", length = 20)
    public String email;
    @Column(name = "dia_chi", length = 50)
    public String address;

    public Customer(int id, String name, long citizenIdentification, String phoneNumber, String email, String address) {
        this.id = id;
        this.name = name;
        this.citizenIdentification = citizenIdentification;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCitizenIdentification() {
        return citizenIdentification;
    }

    public void setCitizenIdentification(long citizenIdentification) {
        this.citizenIdentification = citizenIdentification;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
