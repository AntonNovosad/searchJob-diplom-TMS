package by.teachmeskills.diplom.service;

import by.teachmeskills.diplom.entity.Role;
import by.teachmeskills.diplom.entity.Status;
import by.teachmeskills.diplom.entity.User;
import by.teachmeskills.diplom.repository.CompanyRepository;
import by.teachmeskills.diplom.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public User save(User user) {
        String newPassword = passwordEncoder().encode(user.getPassword());
        user.setPassword(newPassword);
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findById(long id) {
        return userRepository.getById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean delete(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            User user = userRepository.findByEmail(email).get();
            userRepository.delete(user);
            return true;
        } else {
            return false;
        }
    }

    public void updateStatus(Status status, User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            user.setStatus(status);
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, user.getEmail()));
        }
    }

    public void updateRole(Role role, User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            user.setRole(role);
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, user.getEmail()));
        }
    }

    public void update(String firstName, String lastName, User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, user.getEmail()));
        }
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
