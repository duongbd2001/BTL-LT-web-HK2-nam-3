package Hotel.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dat_phong")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ngay_dat")
    private Date checkIn;

    @Column(name = "ngay_tra")
    private Date checkOut;

    @Column(name = "so_ngay_o")
    private int numOfDay;

    @Column(name = "tong_tien")
    private int totalMoney;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private Customer cus;

    @ManyToOne
    @JoinColumn(name = "id_phong")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "id_dich_vu")
    private HotelService hotelService;

//    @OneToMany(mappedBy = "room")
//    private List<Room> roomList;
//
//    @OneToMany(mappedBy = "cus")
//    private List<Customer> customerList;

    public Booking(int id, Date checkIn, Date checkOut, int numOfDay, int totalMoney, Customer customer, Room room, HotelService hotelService) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numOfDay = numOfDay;
        this.totalMoney = totalMoney;
        this.cus = customer;
        this.room = room;
        this.hotelService = hotelService;
    }

    public Booking() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getNumOfDay() {
        return numOfDay;
    }

    public void setNumOfDay(int numOfDay) {
        this.numOfDay = numOfDay;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Customer getCustomer() {
        return cus;
    }

    public void setCustomer(Customer customer) {
        this.cus = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public HotelService getHotelService() {
        return hotelService;
    }

    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

//    public List<Customer> getCustomerList() {
//        return customerList;
//    }
//
//    public void setCustomerList(List<Customer> customerList) {
//        this.customerList = customerList;
//    }
//
//    public List<Room> getRoomList() {
//        return roomList;
//    }
//
//    public void setRoomList(List<Room> roomList) {
//        this.roomList = roomList;
//    }
}
