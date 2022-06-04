package Hotel.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dich_vu")
public class HotelService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dich_vu")
    private int idService;

    @Column(name = "ten_dich_vu", length = 50)
    private String nameOfService;

    @Column(name = "gia")
    private int priceService;

    @OneToMany(mappedBy = "hotelService")
    private List<Booking> bookings;

    public HotelService() {
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public int getPriceService() {
        return priceService;
    }

    public void setPriceService(int priceService) {
        this.priceService = priceService;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
