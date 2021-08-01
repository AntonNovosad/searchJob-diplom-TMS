package by.teachmeskills.diplom.service;

import by.teachmeskills.diplom.dto.ResumeDto;
import by.teachmeskills.diplom.entity.Resume;
import by.teachmeskills.diplom.entity.Role;
import by.teachmeskills.diplom.entity.Status;
import by.teachmeskills.diplom.entity.User;
import by.teachmeskills.diplom.repository.ResumeRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;

    public Resume create(ResumeDto resumeDto) {
        Resume resume = new Resume(10, resumeDto.getName(),
                resumeDto.getWorkExperience(),
                resumeDto.getEducation(),
                resumeDto.getCourses(),
                resumeDto.getLanguage(),
                resumeDto.getAbilities(),
                resumeDto.getAboutMe());
        return resumeRepository.save(resume);
    }

    public List<Resume> getAll() {
        return resumeRepository.findAll();
    }

    public Resume findById(long id) {
        return resumeRepository.getById(id);
    }

    public Optional<Resume> findByName(String name) {
        return resumeRepository.findByName(name);
    }

    public boolean delete(long id) {
        if (resumeRepository.ExistById(id)) {
            Resume resume = resumeRepository.getById(id);
            resumeRepository.delete(resume);
            return true;
        } else {
            return false;
        }
    }

    public void update(long id, ResumeDto resumeDto) {
        if (resumeRepository.ExistById(id)) {
            Resume resume = resumeRepository.getById(id);
            resume.setAbilities(resumeDto.getName());
            resume.setAbilities(resumeDto.getWorkExperience());
            resume.setAbilities(resumeDto.getEducation());
            resume.setAbilities(resumeDto.getCourses());
            resume.setAbilities(resumeDto.getLanguage());
            resume.setAbilities(resumeDto.getAbilities());
            resume.setAbilities(resumeDto.getAboutMe());
            resumeRepository.save(resume);
        } else {
            throw new RuntimeException("");
        }
    }
}
