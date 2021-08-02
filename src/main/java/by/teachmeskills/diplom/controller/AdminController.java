package by.teachmeskills.diplom.controller;

import by.teachmeskills.diplom.entity.Role;
import by.teachmeskills.diplom.entity.Status;
import by.teachmeskills.diplom.service.AdminService;
import by.teachmeskills.diplom.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final UserDetailsServiceImpl userDetailsService;

    @GetMapping("/users")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userDetailsService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public void update(@PathVariable long userId, String firstName, String lastName) {
        userDetailsService.update(userId, firstName, lastName);
    }

    @PutMapping("/update/{userId}/{status}")
    public void updateStatus(@PathVariable long userId, @PathVariable Status status) {
        adminService.updateStatus(userId, status);
    }

    @PutMapping("update/{userId}/{role}")
    public void updateRole(@PathVariable long userId,@PathVariable Role role) {
        adminService.updateRole(userId, role);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) {
        if (adminService.deleteUser(email)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
