package se.sumihiri.spring_my_application_cognito.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.sumihiri.spring_my_application_cognito.configuration.Cognito;

/*@RestController
public class SignInController {

    private final Cognito cognito;

    @Autowired
    public SignInController(Cognito cognito) {
        this.cognito = cognito;
    }

    // Other methods
}
/*import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.sumihiri.spring_my_application_cognito.configuration.Cognito;
import se.sumihiri.spring_my_application_cognito.models.SignInRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
class SignInController {

    private static final Logger logger = LoggerFactory.getLogger(SignInController.class);


    @Value("${aws.cognito.poolId}")
    private String poolId;

    @Value("${aws.cognito.registration.clientId}")
    private String clientId;

    private final Cognito cognito;

    @Autowired
    public SignInController(Cognito cognito) {
        this.cognito = cognito;
    }

    @GetMapping("/sign-in")
    public String getSignIn(Model model) {
        model.addAttribute("signIn", new SignInRequest());
        return "sign-in";
    }

    @PostMapping("/sign-in")
    public String postSignIn(@ModelAttribute SignInRequest request, RedirectAttributes redirectAttributes) {
        var username = request.getUsername();
        var password = request.getPassword();
        var email = request.getEmail(); // Assuming email is part of SignInRequest
        boolean success;

        try {
            success = cognito.signUp(clientId, username, password, email);
            if (success) {
                cognito.confirmUser(poolId, username);
                return "redirect:/";
            } else {
                redirectAttributes.addFlashAttribute("error", "Invalid username or password.");
                return "redirect:/sign-in";
            }
        } catch (Exception e) {
            logger.error("Error during sign-in process for user: {}", username, e);
            redirectAttributes.addFlashAttribute("error", "An error occurred during sign-in. Please try again later.");
            return "redirect:/sign-in";
        }
    }
}/*

/*import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController{

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Your login template
    }

    // Implement methods to handle login form submission and OAuth2 flow with Spring Security
}

 import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.sumihiri.spring_my_application_cognito.configuration.Cognito;
import se.sumihiri.spring_my_application_cognito.models.SignInRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SignInController {

    private static final Logger logger = LoggerFactory.getLogger(SignInController.class);

    @Value("${aws.cognito.poolId}")
    private String poolId;

    @Value("${aws.cognito.registration.clientId}")
    private String clientId;

    private final Cognito cognito;

    @Autowired
    public SignInController(Cognito cognito) {
        this.cognito = cognito;
    }

    @GetMapping("/sign-in")
    public String getSignIn(Model model) {
        model.addAttribute("signIn", new SignInRequest());
        return "sign-in";
    }

    @PostMapping("/sign-in")
    public String postSignIn(@ModelAttribute SignInRequest request, RedirectAttributes redirectAttributes) {
        var username = request.getUsername();
        var password = request.getPassword();
        var email = request.getEmail(); // Assuming email is part of SignInRequest
        boolean success;

        try {
            success = cognito.signUp(clientId, username, password, email);
            if (success) {
                cognito.confirmUser(poolId, username);
                return "redirect:/";
            } else {
                redirectAttributes.addFlashAttribute("error", "Invalid username or password.");
                return "redirect:/sign-in";
            }
        } catch (Exception e) {
            logger.error("Error during sign-in process for user: {}", username, e);
            redirectAttributes.addFlashAttribute("error", "An error occurred during sign-in. Please try again later.");
            return "redirect:/sign-in";+
        }
    }
}*/


