package Hotel.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "thiet_bi")
public class Device {
    @Id
    @Column(name = "thiet_bi")
    private int idDevice;
    @Column(name = "ten_thiet_bi")
    private String nameOfDevice;
    @Column(name = "don_gia")
    private int priceDevice;

    public Device() {
    }

    public int getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
    }

    public String getNameOfDevice() {
        return nameOfDevice;
    }

    public void setNameOfDevice(String nameOfDevice) {
        this.nameOfDevice = nameOfDevice;
    }

    public int getPriceDevice() {
        return priceDevice;
    }

    public void setPriceDevice(int priceDevice) {
        this.priceDevice = priceDevice;
    }
}
