package by.teachmeskills.diplom.controller;

import by.teachmeskills.diplom.entity.Role;
import by.teachmeskills.diplom.entity.Status;
import by.teachmeskills.diplom.entity.User;
import by.teachmeskills.diplom.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
public class AdminController {

    private final UserDetailsServiceImpl userDetailsService;

    @GetMapping("/users")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userDetailsService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{firstName}/{lastName}")
    public void update(@PathVariable String firstName, @PathVariable String lastName, @RequestBody User user) {
        userDetailsService.update(firstName, lastName, user);
    }

    @PutMapping("/update/{status}")
    public void updateStatus(@PathVariable Status status, @RequestBody User user) {
        userDetailsService.updateStatus(status, user);
    }

    @PutMapping("update/{role}")
    public void updateRole(@PathVariable Role role, @RequestBody User user) {
        userDetailsService.updateRole(role, user);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> delete(@PathVariable String email) {
        if (userDetailsService.delete(email)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
