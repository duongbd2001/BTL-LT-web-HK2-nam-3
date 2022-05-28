package Hotel.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_KhachHang")
public class Customer {
    @Id
    @Column(name = "IDKhachHang", nullable = false, unique = true)
    public int id;
    @Column(name = "HoTen", nullable = false, length = 50)
    public String name;
    @Column(name = "CCCD", nullable = false, length = 20)
    public String citizenIdentification;    //Can cuoc cong dan
    @Column(name = "SDT", length = 20)
    public String phoneNumber;
    @Column(name = "EMAIL", length = 20)
    public String email;
    @Column(name = "DiaChi", length = 50)
    public String address;

    public Customer(int id, String name, String citizenIdentification, String phoneNumber, String email, String address) {
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

    public String getCitizenIdentification() {
        return citizenIdentification;
    }

    public void setCitizenIdentification(String citizenIdentification) {
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
