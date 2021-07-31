package by.teachmeskills.diplom.controller;

import by.teachmeskills.diplom.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/home")
@AllArgsConstructor
public class UserController {

    private final UserDetailsServiceImpl userDetailsService;

    @GetMapping("/users")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userDetailsService.allUsers(), HttpStatus.OK);
    }

}
