package by.teachmeskills.diplom.controller;

import by.teachmeskills.diplom.entity.Resume;
import by.teachmeskills.diplom.entity.User;
import by.teachmeskills.diplom.service.ResumeService;
import by.teachmeskills.diplom.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserDetailsServiceImpl userDetailsService;
    private final ResumeService resumeService;

    @PutMapping("/update/{firstName}/{lastName}")
    public void update(@PathVariable String firstName, @PathVariable String lastName, @RequestBody User user) {
        userDetailsService.update(firstName, lastName, user);
    }

    //TODO
    @GetMapping("/resume")
    public ResponseEntity<Resume> getAll() {
        return null;
    }

    @GetMapping("/resume/{id}")
    public ResponseEntity<Resume> getById(@PathVariable long id) {
        return new ResponseEntity<>(resumeService.findById(id), HttpStatus.OK);
    }
}
