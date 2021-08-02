package by.teachmeskills.diplom.service;

import by.teachmeskills.diplom.entity.Company;
import by.teachmeskills.diplom.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company save(Company company) {
        String newPassword = passwordEncoder().encode(company.getPassword());
        company.setPassword(newPassword);
        return companyRepository.save(company);
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Company findById(long id) {
        return companyRepository.getById(id);
    }

    public Optional<Company> findByEmail(String email) {
        return companyRepository.findByEmail(email);
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
