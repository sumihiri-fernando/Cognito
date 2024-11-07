package se.sumihiri.spring_my_application_cognito.controller;

import java.util.List;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import se.sumihiri.spring_my_application_cognito.configuration.Cognito;
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(OAuth2AuthenticationToken token, Model model) {
        if (token != null && token.isAuthenticated()) {
            List<UserTypeData> userList = Cognito.listUsers("eu-north-1_pMjGBAMHh");
            System.out.println(userList);
            model.addAttribute("userList", userList);
        }
        return "home";
    }

    @GetMapping("/sign-up")
    public String signup() {
        return "login";
    }

    @GetMapping("/delete-user/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable String id) {
        Cognito.deleteUser("eu-north-1_pMjGBAMHh",id);

        return "User deleted successfully";
    }
}
