package oktenweb.trysecurity1.controllers;

import oktenweb.trysecurity1.dao.ContactDAO;
import oktenweb.trysecurity1.dao.UserDAO;
import oktenweb.trysecurity1.models.Contact;
import oktenweb.trysecurity1.models.User;
import oktenweb.trysecurity1.services.ContactService;
import oktenweb.trysecurity1.services.UserService;
import oktenweb.trysecurity1.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserDAO userDAO;
    @Autowired
    private ContactService contactService;
    @Autowired
    UserServiceImpl userServiceImpl;

    User userLogged = new User();

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        System.out.println("Login Controller");
        return "login";
    }

    @GetMapping("/goToSecuredPage")
    public String goToSecuredPage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        userLogged = (User) userServiceImpl.loadUserByUsername(auth.getName());
        model.addAttribute("userLogged", userLogged);
        List<Contact> contacts = userLogged.getContacts();
        model.addAttribute("contacts", contacts);
        return "securedPage";
    }


    @PostMapping("/saveUser")
    public String saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword())); // to encode the pass
        userService.save(user);
        return "login";
    }

    @PostMapping("/successURL")
    public String successURL(){

        return "index";
    }

    @GetMapping("/goToIndexPage")
    public String goToIndexPage(){
        return "index";
    }

    @GetMapping("/save")
    public String save(
             Contact contact
    ){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //userLogged = userDAO.findByUsername(auth.getName());
         userLogged = (User) userServiceImpl.loadUserByUsername(auth.getName());

        //Contact contact = new Contact();
        //contact.setContactName("contact security yet another");
        //contact.setEmail("s222@s.s");
        contact.setUser(userLogged);
        contactService.save(contact);
        System.out.println("Contact saved");

        return "index";
    }
}
