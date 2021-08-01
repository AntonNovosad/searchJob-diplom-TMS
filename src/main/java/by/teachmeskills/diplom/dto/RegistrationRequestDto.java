package by.teachmeskills.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequestDto {
    private String emailDto;
    private String passwordDto;
    private String firstNameDto;
    private String lastNameDto;
    private String phoneDto;
}
