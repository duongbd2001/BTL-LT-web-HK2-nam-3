package Hotel.Controller;

import Hotel.Model.Customer;
import Hotel.Model.UserSignIn;
import Hotel.Repository.CustomerRepository;
import Hotel.Repository.SignInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class SignUpController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SignInRepository signInRepository;

    //giao dien cua trang dang ki
    @GetMapping("/sign-up")
    public String signUp(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        UserSignIn userSignIn = new UserSignIn();
        model.addAttribute("userSignIn", userSignIn);
        return "views/signUp";
    }

    @PostMapping("/register")
    public ModelAndView signUp(@RequestParam(name = "fullName") String fullName, @RequestParam(name = "citizenIdentification") String citizenIdentification,
                               @RequestParam(name = "phoneNumber") String phoneNumber, @RequestParam(name = "email") String email, @RequestParam(name = "address") String address,
                               @RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model, HttpServletRequest request) {
        //kiem tra thong tin khach hang co ton tai trong DB khong
        Optional<Customer> customerOptional = customerRepository.findCustomerByNameAndCitizenIdentificationAndPhoneNumberAndEmailAndAddress(fullName, citizenIdentification, phoneNumber, email, address);
        //kiem tra username va password co ton tai trong DB khong
        Optional<UserSignIn> userSignInOptional = signInRepository.findUserSignInByUsernameAndPassword(username, password);
        if (customerOptional.isPresent() || userSignInOptional.isPresent()) {
            //neu khach hang da ton tai hoac account dang ki da ton tai thi dua ra thong bao
            model.addAttribute("situation", "existed");
            model.addAttribute("message", "This field is existed! Please check again.");
            return new ModelAndView("views/signUp");
        } else {
            //luu thong tin cua khach hang va account vao trong DB
            Customer customer = new Customer(fullName, citizenIdentification, phoneNumber, email, address);
            UserSignIn userSignIn = new UserSignIn(customer, username, password);
            customerRepository.save(customer);
            signInRepository.save(userSignIn);
            HttpSession session = request.getSession();
            session.setAttribute("customer",customer);
            model.addAttribute("name", customer.getName());
            model.addAttribute("situation","signed_in");
            model.addAttribute("situation", "signed_in");
            return new ModelAndView("views/home");
        }
    }
}
