package by.teachmeskills.diplom.service;

import by.teachmeskills.diplom.dto.ResumeDto;
import by.teachmeskills.diplom.entity.Resume;
import by.teachmeskills.diplom.repository.ResumeRepository;
import by.teachmeskills.diplom.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ResumeService {

    private final static String RESUME_NOT_FOUND_MSG = "resume with id %s not found";
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;

    public Resume create(String email, ResumeDto resumeDto) {
        if (userRepository.findByEmail(email).isPresent()) {
            Resume resume = new Resume(10, resumeDto.getName(),
                    resumeDto.getWorkExperience(),
                    resumeDto.getEducation(),
                    resumeDto.getCourses(),
                    resumeDto.getLanguage(),
                    resumeDto.getAbilities(),
                    resumeDto.getAboutMe());
            return resumeRepository.save(resume);
        } else {
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email));
        }
    }

    public List<Resume> getAll() {
        return resumeRepository.findAll();
    }

    public Resume getById(long id) {
        return resumeRepository.getById(id);
    }

    public Optional<Resume> findByName(String name) {
        return resumeRepository.findByName(name);
    }

    public boolean delete(long id) {
        if (resumeRepository.existsById(id)) {
            Resume resume = resumeRepository.getById(id);
            resumeRepository.delete(resume);
            return true;
        } else {
            return false;
        }
    }

    public void update(long id, ResumeDto resumeDto) {
        if (resumeRepository.existsById(id)) {
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
            throw new RuntimeException(String.format(RESUME_NOT_FOUND_MSG, id));
        }
    }
}
