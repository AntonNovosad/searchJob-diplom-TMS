package by.teachmeskills.diplom.service;

import by.teachmeskills.diplom.dto.VacancyDto;
import by.teachmeskills.diplom.entity.Resume;
import by.teachmeskills.diplom.entity.Vacancy;
import by.teachmeskills.diplom.repository.ResumeRepository;
import by.teachmeskills.diplom.repository.UserRepository;
import by.teachmeskills.diplom.repository.VacancyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class VacancyService {

    private final static String VACANCY_NOT_FOUND_MSG = "vacancy with id %s not found";
    private final VacancyRepository vacancyRepository;
    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;

    public Vacancy create(VacancyDto vacancyDto) {
        Vacancy vacancy = new Vacancy(10, vacancyDto.getName(),
                vacancyDto.getRequirements(),
                vacancyDto.getAbilities(),
                vacancyDto.getProposition(), null);
        return vacancyRepository.save(vacancy);
    }

//TODO
//    public void setUserResume(long vacancyId, String email) {
//        if (vacancyRepository.existsById(vacancyId)) {
//            Vacancy vacancy = vacancyRepository.getById(vacancyId);
//            Set<Resume> resumeSet = vacancy.getResumeList();
//            resumeSet.add(userRepository.findByEmail(email).get().getResume());
//        } else {
//            throw new RuntimeException("Vacancy not exist");
//        }
//    }

    public List<Vacancy> getAll() {
        return vacancyRepository.findAll();
    }

    public Vacancy findById(long id) {
        return vacancyRepository.getById(id);
    }

    public Optional<Vacancy> findByName(String name) {
        return vacancyRepository.findByName(name);
    }

    public boolean delete(long id) {
        if (vacancyRepository.existsById(id)) {
            Vacancy vacancy = vacancyRepository.getById(id);
            vacancyRepository.delete(vacancy);
            return true;
        } else {
            return false;
        }
    }

    public void update(long id, VacancyDto vacancyDto) {
        if (vacancyRepository.existsById(id)) {
            Vacancy vacancy = vacancyRepository.getById(id);
            vacancy.setAbilities(vacancyDto.getName());
            vacancy.setAbilities(vacancyDto.getRequirements());
            vacancy.setAbilities(vacancyDto.getAbilities());
            vacancy.setAbilities(vacancyDto.getProposition());
            vacancyRepository.save(vacancy);
        } else {
            throw new RuntimeException(String.format(VACANCY_NOT_FOUND_MSG, id));
        }
    }
}
