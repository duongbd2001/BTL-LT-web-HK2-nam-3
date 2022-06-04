package Hotel.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phong")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phong")
    private int idRoom;

    @Column(name = "ten_phong", length = 50)
    private String nameOfRoom;

    @Column(name = "trang_thai")
    private String status;

    @OneToOne
    @JoinColumn(name = "id_loai_phong")
    private TypeOfRoom typeOfRoom;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

    public Room() {
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameOfRoom() {
        return nameOfRoom;
    }

    public void setNameOfRoom(String nameOfRoom) {
        this.nameOfRoom = nameOfRoom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TypeOfRoom getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(TypeOfRoom typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
