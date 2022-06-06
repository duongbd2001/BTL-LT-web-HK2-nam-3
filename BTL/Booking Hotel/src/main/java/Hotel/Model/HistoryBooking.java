package Hotel.Model;

import java.util.Date;

public class HistoryBooking {
    private int id;
    private String nameOfRoom;
    private Date checkIn;
    private Date checkOut;
    private int totalMoney;

    public HistoryBooking() {
    }

    public HistoryBooking(int id, String nameOfRoom, Date checkIn, Date checkOut, int totalMoney) {
        this.id = id;
        this.nameOfRoom = nameOfRoom;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalMoney = totalMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfRoom() {
        return nameOfRoom;
    }

    public void setNameOfRoom(String nameOfRoom) {
        this.nameOfRoom = nameOfRoom;
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

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
