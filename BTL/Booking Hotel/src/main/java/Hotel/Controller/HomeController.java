package Hotel.Controller;

import Hotel.Model.Customer;
import Hotel.Model.UserSignIn;
import Hotel.Repository.SignInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private SignInRepository signInRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("situation","signIn");
        return "views/home";
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
//        UserSignIn userSignIn = signInRepository.findByUsernameAndPassword();
//        model.addAttribute("user", userSignIn);
        return "views/profile";
    }
}
