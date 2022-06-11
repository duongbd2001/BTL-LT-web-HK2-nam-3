package Hotel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class BookingController {
    @GetMapping("/booking")
    public String booking(){
        return "views/booking";
    }
    @GetMapping("/booking/search")
    public String bookingSearch(@RequestParam(name = "checkIn") String checkIn, @RequestParam(name = "checkOut")String checkOut){

        return "views/booking";
    }
}
