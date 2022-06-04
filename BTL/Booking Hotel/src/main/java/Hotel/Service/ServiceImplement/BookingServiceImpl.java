package Hotel.Service.ServiceImplement;

import Hotel.Common.IDaoCommon;
import Hotel.Model.Booking;
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
    public List<Booking> findListBookingByID(Integer id) {
        return bookingRepository.findListBookingById(id, iDaoCommon);
    }

    @Override
    public List<Integer> findTotalMoney(Integer idCustomer) {
        return bookingRepository.findTotalMoney(idCustomer);
    }
}
