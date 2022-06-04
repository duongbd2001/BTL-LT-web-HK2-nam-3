package Hotel.Service;

import Hotel.Model.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> findListBookingByID(Integer id);
    List<Integer> findTotalMoney(Integer idCustomer);
}
