package Hotel.Controller;

import Hotel.Model.UserSignIn;
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
public class HomeController {
    @Autowired
    private SignInRepository signInRepository;

    @GetMapping("/")
    public String homePage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null && session.getAttribute("password") != null) {
            model.addAttribute("situation", "signed_in");
            return "views/home";
        }else {
            model.addAttribute("situation", "signIn");
            return "views/home";
        }
    }

    @PostMapping("/login")
    public ModelAndView homePage(@RequestParam String username, @RequestParam String password, Model model, HttpServletRequest request) {
        Optional<UserSignIn> userSignIn = signInRepository.findByUsernameAndPassword(username, password);
        HttpSession session = request.getSession();
        if (userSignIn.isPresent()) {
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            model.addAttribute("situation", "signed_in");
            return new ModelAndView("views/home");
        } else {
            model.addAttribute("situation","formSignIn");
            model.addAttribute("message", "Login failed! Please check your password");
            return new ModelAndView("views/home");
        }
    }

    @GetMapping("/sign-out")
    public String signOut(HttpServletRequest request, Model model){
        model.addAttribute("situation", "signIn");
        return "views/home";
    }

    @GetMapping("/profile")
    public String profile() {
        return "views/profile";
    }
}
