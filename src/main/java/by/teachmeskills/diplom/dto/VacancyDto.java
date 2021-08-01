package by.teachmeskills.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacancyDto {
    private String name;
    private String requirements;
    private String abilities;
    private String proposition;
}
