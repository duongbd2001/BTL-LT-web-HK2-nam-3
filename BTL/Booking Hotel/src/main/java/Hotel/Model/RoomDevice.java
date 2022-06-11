package Hotel.Model;

import javax.persistence.*;

@Entity
@Table(name = "phong_thiet_bi")
public class RoomDevice {
    @Id
    private int id;

    @OneToOne
    @JoinColumn(name = "id_thiet_bi")
    private Device idDevice;

    @OneToOne
    @JoinColumn(name = "id_phong")
    private Room idRoom;

    @Column(name = "so_luong")
    private int numOfDevice;

    public RoomDevice() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Device getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(Device idDevice) {
        this.idDevice = idDevice;
    }

    public Room getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Room idRoom) {
        this.idRoom = idRoom;
    }

    public int getNumOfDevice() {
        return numOfDevice;
    }

    public void setNumOfDevice(int numOfDevice) {
        this.numOfDevice = numOfDevice;
    }
}
