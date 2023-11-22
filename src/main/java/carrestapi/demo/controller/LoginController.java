package carrestapi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Assuming "login" is the name of your login page
    }

//    @GetMapping("/")
//    public String showIndexPage() {
//        return "index"; // Zwraca nazwę pliku HTML bez rozszerzenia
//    }
}
