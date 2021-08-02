package by.teachmeskills.diplom.controller;

import by.teachmeskills.diplom.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserDetailsServiceImpl userDetailsService;

    @PutMapping("/update/{userId}")
    public void update(@PathVariable long userId, String firstName, String lastName) {
        userDetailsService.update(userId, firstName, lastName);
    }
}
