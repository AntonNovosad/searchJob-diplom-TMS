package by.teachmeskills.diplom.repository;

import by.teachmeskills.diplom.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    Optional<Resume> findByName(String name);
    boolean ExistById(long id);
}
