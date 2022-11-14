package net.spring_registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import net.spring_registration.model.User;
import net.spring_registration.repository.UserRepository;

@Controller


public class UserController {
	
	@Autowired
    private UserRepository userRepo;
    
	//To test the home page
    @GetMapping("home")
    public String viewHomePage() {
        return "index";
    }
    
    @GetMapping("/register")
    public String showSignUpForm(Model model) {
    	model.addAttribute("user", new User());
    	return "signup_form";
    }
    
    @PostMapping("/process_register")
    public String saveRegistration(User user) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
    	return "register_success";
    }
    
    
    @GetMapping("/list_users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
        //Pour retourner la vue users.html
        return "users";
    }

}
