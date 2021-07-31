package by.teachmeskills.diplom.controller;

import by.teachmeskills.diplom.entity.Role;
import by.teachmeskills.diplom.entity.Status;
import by.teachmeskills.diplom.entity.User;
import by.teachmeskills.diplom.entity.dto.RegistrationRequestDto;
import by.teachmeskills.diplom.repository.UserRepository;
import by.teachmeskills.diplom.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/home")
@AllArgsConstructor
public class RegistrationController {

    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/reg")
    public ResponseEntity<?> registration(@RequestBody RegistrationRequestDto request) {
        if (userDetailsService.findByEmail(request.getEmailDto()).isPresent()) {
            return new ResponseEntity<>("User exist", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(userDetailsService.saveUser(
                    new User(10,
                            request.getEmailDto(),
                            request.getPasswordDto(),
                            request.getFirstNameDto(),
                            request.getLastNameDto(),
                            request.getPhoneDto(),
                            Role.USER,
                            Status.ACTIVE)
            ), HttpStatus.OK);
        }
    }
}
