/*package se.sumihiri.spring_my_application_cognito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.sumihiri.spring_my_application_cognito.service.UserService;

@Controller
class RegistrationController {

    @Autowired
    private UserService userService; // Your service for user management

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User;
        return "register"; // Your registration template
    }

   @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.registerUser(User);
        return "registration_success"; // Your success template
    }*/
