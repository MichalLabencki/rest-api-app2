package carrestapi.demo;

import java.util.List;

import carrestapi.demo.model.User;
import org.springframework.security.core
        .userdetails.UserDetailsService;

public interface UserService
        extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);
    List<User> getAll();
}
