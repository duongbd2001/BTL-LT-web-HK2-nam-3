package Hotel.Controller;

import Hotel.Model.Customer;
import Hotel.Model.UserSignIn;
import Hotel.Repository.CustomerRepository;
import Hotel.Repository.SignInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class SignUpController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SignInRepository signInRepository;

    @GetMapping("/sign-up")
    public String signUp(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "views/signUp";
    }

    @PostMapping("/register")
    public ModelAndView signUp(@ModelAttribute(name = "customer") Customer customer, Model model, @ModelAttribute(name = "userSignIn")UserSignIn userSignIn) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByCitizenIdentification(customer.getCitizenIdentification());
        Optional<UserSignIn> userSignInOptional = signInRepository.findByUsernameAndPassword(userSignIn.getUsername(), userSignIn.getPassword());
        if (customerOptional.isPresent()){
            model.addAttribute("situation","existed");
            model.addAttribute("message","This field is existed! Please check again.");
            return new ModelAndView("views/signUp");
        }else{
            if (!userSignInOptional.isPresent()){
                customerRepository.save(customer);
                signInRepository.save(userSignIn);
                model.addAttribute("situation","success");
                return new ModelAndView("views/home");
            }else{
                model.addAttribute("situation","existed");
                model.addAttribute("message","This field is existed! Please check again.");
                return new ModelAndView("views/signUp");
            }
        }
    }
}
