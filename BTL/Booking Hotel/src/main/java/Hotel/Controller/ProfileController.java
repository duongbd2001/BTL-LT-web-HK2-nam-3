package Hotel.Controller;

import Hotel.Model.Booking;
import Hotel.Model.Customer;
import Hotel.Repository.BookingRepository;
import Hotel.Service.BookingService;
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
    private BookingRepository bookingRepository;
    private BookingService bookingService;
    //    Chuyen huong den trang profile
    @GetMapping("/profile")
    public ModelAndView profile(@ModelAttribute(name = "user") Customer customer, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        customer = (Customer) session.getAttribute("customer");
        model.addAttribute("user", customer);
        model.addAttribute("situation","profile");
        ModelAndView modelA = new ModelAndView("views/profile");
        modelA.addObject("user", customer);
        return modelA;
    }

    //form lich su dat phong
    @GetMapping("/booking-history")
    public String bookingHistory(Model model, HttpServletRequest request){
        //lay thong tin nguoi dung khi da dang nhap
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        List<Booking> bookingList = bookingService.findListBookingByID(customer.getId());
        model.addAttribute("historyBooking", bookingList);
        model.addAttribute("situation","bookingHistory");
        return "views/profile";
    }
}
