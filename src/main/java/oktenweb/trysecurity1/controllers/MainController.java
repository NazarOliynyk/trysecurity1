package oktenweb.trysecurity1.controllers;

import oktenweb.trysecurity1.dao.ContactDAO;
import oktenweb.trysecurity1.dao.UserDAO;
import oktenweb.trysecurity1.models.Contact;
import oktenweb.trysecurity1.models.User;
import oktenweb.trysecurity1.services.ContactService;
import oktenweb.trysecurity1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/")
    public String index(){
        return "login";
    }
    @GetMapping("/login")
    public String login(Model model
                       // @RequestParam("username") String username,
                       // @RequestParam("password") String password
    ){
//    List<User> userList = userService.findAll();
//       System.out.println(username+ ", "+password);
        System.out.println("SOMETHING");
        return "login";
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

    @GetMapping("/save")
    public String save(){
        User user = new User();

       user = userDAO.findOne(2);
        System.out.println(user.getUsername()+", "+user.getPassword());
        Contact contact = new Contact();
        contact.setContactName("contact security yet another");
        contact.setEmail("s222@s.s");
        contact.setUser(user);
        contactService.save(contact);
        System.out.println("Contact saved");

        return "login";
    }
}
