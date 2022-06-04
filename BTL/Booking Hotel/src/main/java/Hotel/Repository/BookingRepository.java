package Hotel.Repository;

import Hotel.Common.IDaoCommon;
import Hotel.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    default List< Booking> findListBookingById(Integer id, IDaoCommon daoCommon) {
        StringBuilder sql = new StringBuilder("select dat_phong.id, phong.ten_phong, dat_phong.ngay_dat, dat_phong.ngay_tra, dich_vu.gia + loai_phong.don_gia + thiet_bi.don_gia as tong_tien " +
                "from dich_vu, loai_phong, thiet_bi, phong, phong_thiet_bi,dat_phong " +
                "where dat_phong.id_phong = phong.id_phong " +
                "and phong.id_phong = phong_thiet_bi.id_phong " +
                "and phong_thiet_bi.id_thiet_bi = thiet_bi.id_thiet_bi " +
                "and loai_phong.id_loai_phong = phong.id_loai_phong");
        Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        List<Booking> list = daoCommon.list(sql.toString(), param, Booking.class);
        return list;
    }
    @Query("select dich_vu.gia + loai_phong.don_gia + thiet_bi.don_gia as tong_tien " +
            "from dich_vu, loai_phong, thiet_bi, phong, phong_thiet_bi,dat_phong " +
            "where dat_phong.id_phong = phong.id_phong " +
            "and phong.id_phong = phong_thiet_bi.id_phong " +
            "and phong_thiet_bi.id_thiet_bi = thiet_bi.id_thiet_bi " +
            "and loai_phong.id_loai_phong = phong.id_loai_phong " +
            "and dat_phong.id_khach_hang = ?1")
    List<Integer> findTotalMoney(Integer idCustomer);
}
