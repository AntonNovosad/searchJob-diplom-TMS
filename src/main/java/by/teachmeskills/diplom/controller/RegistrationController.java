package by.teachmeskills.diplom.controller;

import by.teachmeskills.diplom.entity.Role;
import by.teachmeskills.diplom.entity.Status;
import by.teachmeskills.diplom.entity.User;
import by.teachmeskills.diplom.dto.RegistrationRequestDto;
import by.teachmeskills.diplom.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/home")
@AllArgsConstructor
public class RegistrationController {

    private final static String USER_EXIST_MSG = "user with email %s exist";
    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/reg")
    public ResponseEntity<?> registration(@RequestBody RegistrationRequestDto request) {
        if (userDetailsService.findByEmail(request.getEmailDto()).isPresent()) {
            return new ResponseEntity<>(String.format(USER_EXIST_MSG, request.getEmailDto()), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(userDetailsService.save(
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
