package by.teachmeskills.diplom.service;

import by.teachmeskills.diplom.entity.Company;
import by.teachmeskills.diplom.entity.Role;
import by.teachmeskills.diplom.entity.Status;
import by.teachmeskills.diplom.entity.User;
import by.teachmeskills.diplom.repository.CompanyRepository;
import by.teachmeskills.diplom.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public boolean deleteUser(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            User user = userRepository.findByEmail(email).get();
            userRepository.delete(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteCompany(String email) {
        if (companyRepository.findByEmail(email).isPresent()) {
            Company company = companyRepository.findByEmail(email).get();
            companyRepository.delete(company);
            return true;
        } else {
            return false;
        }
    }

    public void updateStatus(long id, Status status) {
        if (userRepository.existsById(id)) {
            User user = userRepository.getById(id);
            user.setStatus(status);
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, userRepository.getById(id).getEmail()));
        }
    }

    public void updateRole(long id, Role role) {
        if (userRepository.existsById(id)) {
            User user = userRepository.getById(id);
            user.setRole(role);
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, userRepository.getById(id).getEmail()));
        }
    }
}
