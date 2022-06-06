package Hotel.Service.ServiceImplement;

import Hotel.Common.IDaoCommon;
import Hotel.Model.Booking;
import Hotel.Model.HistoryBooking;
import Hotel.Repository.BookingRepository;
import Hotel.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private IDaoCommon iDaoCommon;

    @Override
    public List<HistoryBooking> findListBookingByCustomerID(Integer idCustomer) {
        return bookingRepository.findListBookingByCustomerID(idCustomer, iDaoCommon);
    }
}
