package Hotel.Controller;

import Hotel.Model.Customer;
import Hotel.Model.HistoryBooking;
import Hotel.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProfileController {

//    @Autowired
    private BookingRepository bookingRepository;
    //    Chuyen huong den trang profile
    @GetMapping("/profile")
    public ModelAndView profile(@ModelAttribute(name = "user") Customer customer, Model model, HttpServletRequest request) {
        //lay thong tin nguoi dung khi da dang nhap
        HttpSession session = request.getSession();
        customer = (Customer) session.getAttribute("customer");

        //hien thi thong tin ca nhan cua nguoi dung
        model.addAttribute("user", customer);
//        model.addAttribute("situation","profile");
        ModelAndView modelA = new ModelAndView("views/profile");
        modelA.addObject("user", customer);

        //hien thi thong tin danh sach cac phong da dat cua khach hang
//        List<HistoryBooking> bookingList = bookingRepository.findListBookingByCustomerID(customer.getId());
//        model.addAttribute("historyBooking", bookingList);
//        modelA.addObject("historyBooking",bookingList);
//        model.addAttribute("situation","bookingHistory");
        return modelA;
    }
}
