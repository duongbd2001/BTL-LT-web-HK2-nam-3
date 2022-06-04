package Hotel.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loai_phong")
public class TypeOfRoom {
    @Id
    @Column(name = "id_loai_phong")
    private int idTypeOfRoom;
    @Column(name = "ten_loai_phong", length = 50)
    private String nameTypeOfRoom;
    @Column(name = "don_gia")
    private int price;
    @Column(name = "so_nguoi")
    private int numOfPeple;
    @Column(name = "so_giuong")
    private int numOfBed;

    public TypeOfRoom() {
    }

    public int getIdTypeOfRoom() {
        return idTypeOfRoom;
    }

    public void setIdTypeOfRoom(int idTypeOfRoom) {
        this.idTypeOfRoom = idTypeOfRoom;
    }

    public String getNameTypeOfRoom() {
        return nameTypeOfRoom;
    }

    public void setNameTypeOfRoom(String nameTypeOfRoom) {
        this.nameTypeOfRoom = nameTypeOfRoom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumOfPeple() {
        return numOfPeple;
    }

    public void setNumOfPeple(int numOfPeple) {
        this.numOfPeple = numOfPeple;
    }

    public int getNumOfBed() {
        return numOfBed;
    }

    public void setNumOfBed(int numOfBed) {
        this.numOfBed = numOfBed;
    }
}
