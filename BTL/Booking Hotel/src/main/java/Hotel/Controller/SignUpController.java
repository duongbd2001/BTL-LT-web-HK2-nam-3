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
import org.springframework.web.bind.annotation.RequestParam;
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
        UserSignIn userSignIn = new UserSignIn();
        model.addAttribute("userSignIn", userSignIn);
        return "views/signUp";
    }

//    @PostMapping("/register")
//    public ModelAndView signUp(@ModelAttribute(name = "customer") Customer customer, Model model, @ModelAttribute(name = "userSignIn")UserSignIn userSignIn) {
//        Optional<Customer> customerOptional = customerRepository.findCustomerByCitizenIdentification(customer.getCitizenIdentification());
//        Optional<UserSignIn> userSignInOptional = signInRepository.findByUsernameAndPassword(userSignIn.getUsername(), userSignIn.getPassword());
//        if (customerOptional.isPresent()){
//            model.addAttribute("situation","existed");
//            model.addAttribute("message","This field is existed! Please check again.");
//            return new ModelAndView("views/signUp");
//        }else{
//            if (!userSignInOptional.isPresent()){
//                customerRepository.save(customer);
//                signInRepository.save(userSignIn);
//                model.addAttribute("situation","success");
//                return new ModelAndView("views/home");
//            }else{
//                model.addAttribute("situation","existed");
//                model.addAttribute("message","This field is existed! Please check again.");
//                return new ModelAndView("views/signUp");
//            }
//        }
//    }

    @PostMapping("/register")
    public ModelAndView signUp(@RequestParam (name = "fullName") String fullName, @RequestParam(name = "citizenIdentification") String citizenIdentification,
                               @RequestParam (name = "phoneNumber") String phoneNumber, @RequestParam(name = "email") String email, @RequestParam(name = "address") String address,
                               @RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByNameAndCitizenIdentificationAndPhoneNumberAndEmailAndAddress(fullName,citizenIdentification, phoneNumber, email, address);
        Optional<UserSignIn> userSignInOptional = signInRepository.findUserSignInByUsernameAndPassword(username, password);
        if (customerOptional.isPresent()){
            model.addAttribute("situation","existed");
            model.addAttribute("message","This field is existed! Please check again.");
            return new ModelAndView("views/signUp");
        }else{
            if (!userSignInOptional.isPresent()){
                Customer customer = new Customer(fullName, citizenIdentification, phoneNumber, email, address);
                customerRepository.save(customer);
                UserSignIn userSignIn = new UserSignIn();
                userSignIn.setUsername(username);
                userSignIn.setPassword(password);
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
