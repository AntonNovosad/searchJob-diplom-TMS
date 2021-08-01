package by.teachmeskills.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
    private String name;
    private String workExperience;
    private String education;
    private String courses;
    private String language;
    private String abilities;
    private String aboutMe;
}
