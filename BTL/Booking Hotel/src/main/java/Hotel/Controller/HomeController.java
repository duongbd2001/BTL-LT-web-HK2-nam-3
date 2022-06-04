package Hotel.Controller;

import Hotel.Model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

//    Trang chu khi chua dang nhap
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("situation","signIn");
        return "views/home";
    }

//    Trang chu da dang nhap
    @GetMapping("/home")
    public ModelAndView home(Model model, @ModelAttribute(name = "user") Customer customer, HttpServletRequest request) {
        HttpSession session = request.getSession();
        customer = (Customer) session.getAttribute("customer");
        model.addAttribute("name", customer.getName());
        model.addAttribute("situation","signed_in");
        return new ModelAndView("views/home");
    }
}
