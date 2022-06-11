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
public class SignInController {
    @Autowired
    private SignInRepository signInRepository;
    @Autowired
    private CustomerRepository customerRepository;

    //giao dien dang nhap
    @GetMapping("/login")
    public String signIn(){
        return "views/signIn";
    }

    //action dang nhap va thao tac kiem tra tai khoan & mat khau
    @PostMapping("/sign-in")
    public ModelAndView homePage(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model, HttpServletRequest request) {
        //kiem tra account nhap vao co ton tai hay khong
        Optional<UserSignIn> userSignIn = signInRepository.findUserSignInByUsernameAndPassword(username, password);
        HttpSession session = request.getSession();
        if (userSignIn.isPresent()) {   //neu account ton tai
            //lay ra du lieu cua doi tuong account trong DB
            UserSignIn signIn = signInRepository.findUserSignInModelByUsernameAndPassword(username, password);
            //lay ra du lieu cua khach hang trong DB thong qua account
            Customer customer = customerRepository.findCustomerById(signIn.getCustomer().getId());
            session.setAttribute("customer", customer);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            model.addAttribute("situation", "signed_in");
            //hien thi ten cua khach hang len navbar
            model.addAttribute("name", customer.getName());
            return new ModelAndView("views/home");
        }else {     //neu account ko ton tai thi dua ra message
            model.addAttribute("message", "Invalid username or password");
            return new ModelAndView("views/signIn");
        }
    }

    //dang xuat
    @GetMapping("/sign-out")
    public String signOut(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.removeAttribute("password");
        model.addAttribute("situation", "signIn");
        return "views/home";
    }
}
