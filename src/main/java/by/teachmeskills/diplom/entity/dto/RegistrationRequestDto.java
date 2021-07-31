package by.teachmeskills.diplom.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
