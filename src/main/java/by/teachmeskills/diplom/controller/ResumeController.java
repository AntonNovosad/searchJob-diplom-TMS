package by.teachmeskills.diplom.controller;


import by.teachmeskills.diplom.dto.ResumeDto;
import by.teachmeskills.diplom.entity.Resume;
import by.teachmeskills.diplom.service.ResumeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/resume")
@AllArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping("/create")
    public ResponseEntity<Resume> createResume(ResumeDto resumeDto) {
        return new ResponseEntity<>(resumeService.create(resumeDto), HttpStatus.OK);
    }
}
