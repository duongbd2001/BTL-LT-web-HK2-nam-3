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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class SignInController {
    @Autowired
    private SignInRepository signInRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/login")
    public String signIn(){
        return "views/signIn";
    }

    @PostMapping("/sign-in")
    public ModelAndView homePage(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model, HttpServletRequest request) {
//        Optional<UserSignIn> userSignIn = signInRepository.findByUsernameAndPassword(username, password);
        Optional<UserSignIn> userSignIn = signInRepository.findUserSignInByUsernameAndPassword(username, password);
        HttpSession session = request.getSession();
        if (userSignIn.isPresent()) {
            UserSignIn signIn = signInRepository.findUserSignInModelByUsernameAndPassword(username, password);
            Customer customer = customerRepository.findCustomerById(signIn.getUserID());
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            model.addAttribute("situation", "signed_in");
            model.addAttribute("name", customer.getName());
            return new ModelAndView("views/home");
        }else {
            model.addAttribute("message", "Invalid username or password");
            return new ModelAndView("views/signIn");
        }
    }

    @GetMapping("/sign-out")
    public String signOut(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.removeAttribute("password");
        model.addAttribute("situation", "signIn");
        return "views/home";
    }
}
