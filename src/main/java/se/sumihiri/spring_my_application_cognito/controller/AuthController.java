package se.sumihiri.spring_my_application_cognito.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import se.sumihiri.spring_my_application_cognito.configuration.Cognito;

import se.sumihiri.spring_my_application_cognito.models.SignUpRequest;


@Controller
public class AuthController{

    class SignUpController {

        private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);

        @Value("${aws.cognito.poolId}")
        private String poolId;

        @Value("${aws.cognito.registration.clientId}")
        private String clientId;


        @GetMapping("/sign-up")
        public String getSignUp(Model model){
            model.addAttribute("signUp", new SignUpRequest());
            return "sign-up";
        }

        @PostMapping("/sign-up")
        public String postSignUp(@ModelAttribute SignUpRequest request, Model model) {
            String username = request.getUsername();
            boolean success = false;

            try {
                success = Cognito.signUp(clientId, username, request.getPassword(), request.getEmail());
                if (success) {
                    Cognito.confirmUser(poolId, username);
                }
            } catch (Exception e) {
                logger.error("Error during sign-up for user {}: {}", username, e.getMessage());
            }

            if (success) {
                model.addAttribute("message", "Sign-up successful! Please check your email to confirm your account.");
                return "redirect:/";
            } else {
                model.addAttribute("error", "Sign-up failed. Please try again.");
                return "sign-up";
            }



        }

        @DeleteMapping("/delete/{username}")
        public String deleteUser(@PathVariable String username) {
            try {
                Cognito.deleteUser(poolId, username);
                return "User account deleted successfully";
            } catch (Exception e) {
                // Log the exception and return an error message
                System.err.println("Error deleting user: " + e.getMessage());
                return "Failed to delete user account";
            }
        }}}



