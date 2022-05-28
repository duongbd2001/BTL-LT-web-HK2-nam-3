//package Hotel.Controller;
//
//import Hotel.Model.UserSignIn;
//import Hotel.Repository.SignInRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Optional;
//
//@Controller
//public class SignInController {
//    @Autowired
//    private SignInRepository signInRepository;
//    @PostMapping("/login")
//    public String homePage(@RequestParam String username, @RequestParam String password, Model model){
//        Optional<UserSignIn> userSignIn = signInRepository.findUserSignInModelByUsernameAndPassword(username,password);
//        if (userSignIn.isPresent()){
//            model.addAttribute("situation", "signed_in");
//            return "views/home" ;
//        }
//        model.addAttribute("situation", "signIn")
//        model.addAttribute("message","Login failed! Please check your password");
//        return "views/home";
//    }
//}
