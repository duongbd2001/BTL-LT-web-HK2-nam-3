package Hotel.Service;

import Hotel.Model.Booking;
import Hotel.Model.HistoryBooking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    List<HistoryBooking> findListBookingByCustomerID(Integer idCustomer);
}
